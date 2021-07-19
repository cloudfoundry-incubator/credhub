package db.migration.common

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings
import java.sql.Types
import java.util.UUID
import org.cloudfoundry.credhub.utils.UuidUtil
import org.flywaydb.core.api.migration.BaseJavaMigration
import org.flywaydb.core.api.migration.Context
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.SingleConnectionDataSource

class V20_1__set_uuid_in_encryption_key_canary : BaseJavaMigration() {
    @SuppressFBWarnings(value = ["NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"], justification = "The database will definitely exist")
    @Throws(Exception::class)
    override fun migrate(context: Context) {
        val jdbcTemplate = JdbcTemplate(SingleConnectionDataSource(context.connection, true))
        val databaseName = jdbcTemplate
            .dataSource
            ?.getConnection()
            ?.metaData
            ?.databaseProductName
            ?.toLowerCase()
        val types = intArrayOf(Types.VARBINARY, Types.BIGINT)
        val canaryIds = jdbcTemplate.queryForList(
            "select id from encryption_key_canary",
            Long::class.java
        )
        for (id in canaryIds) {
            jdbcTemplate.update(
                "update encryption_key_canary set uuid = ? where id = ?",
                databaseName?.let { getParams(it, id) },
                types
            )
        }
    }

    private fun getParams(databaseName: String, id: Long): Array<Any> {
        val uuid = UUID.randomUUID()
        return if ("postgresql" == databaseName) {
            arrayOf(uuid, id)
        } else {
            arrayOf(UuidUtil.uuidToByteArray(uuid), id)
        }
    }
}
