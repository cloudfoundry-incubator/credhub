# CredHub Documentation

This repository contains documentation pertinent to general application operation and features of CredHub. Additional documentation related to configuration and deployment via BOSH can be found in the [release repo.](https://github.com/pivotal-cf/credhub-release/tree/master/docs)

The API endpoints and associated CLI commands for interactions with CredHub are documented on the [CredHub API and CLI reference site.](https://credhub-api.cfapps.io)

## Product Initiatives

#### In Progress

TBD

#### Future

TBD

#### Completed

* **Config server implementation with BOSH Director**

    The goal of this initiative is to provide a [BOSH config server][1] conformant API to allow CredHub to be used for generating and storing BOSH deployment credentials. Additional information can be [found here.](bosh-config-server.md)

    **Status**: Released in v1.0.0

[1]:https://github.com/cloudfoundry/bosh-notes/blob/master/config-server.md

* **Credential access and change logging**

    The goal of this initiative is to provide logs for all access and changes to credentials.

    **Status**: Released in v1.0.0

* **Encryption Key Rotation**

    The goal of this initiative is to provide a method to rotate the encryption key used by CredHub to secure credential data.

    **Status**: Released in v1.0.0

* **Luna HSM encryption provider support**

    The goal of this initiative is to provide support for using a Luna hardware security module (HSM) as an encryption provider. Additional information can be [found here.](https://github.com/pivotal-cf/credhub-release/blob/master/docs/configure-luna-hsm.md)

    **Status**: Released in v1.0.0

* **CredHub client library for Java**

    The goal of this initiative is to provide a supported Java client library for CredHub. Additional information can be [found here.](https://projects.spring.io/spring-credhub/)

    **Status**: Completed

* **Integration with Pivotal Ops Manager**

    The goal of this initiative is to integrate with Pivotal Ops Manager to store platform credentials in CredHub to provide the security benefits of CredHub to these users. Additional information can be [found here.](https://docs.pivotal.io/tiledev/credhub.html)

    **Status**: Released in v1.0.0

* **Enable mutual TLS authentication mechanism for applications**

    The goal of this initiative is to allow applications, services and other non-user consumers to authenticate via mutual TLS client certificates. Additional information can be [found here.](mutual-tls.md)

    **Status**: Released in v1.1.0

* **Authorization - Secure Service Credentials**

    The goal of this initiative is to enable authorization via ACLs to enable the secure service credential workflow. Additional information can be [found here.](authorization-and-permissions.md)

    **Status**: Released in v1.1.0

* **Integration with Concourse CI**

    The goal of this initiative is to integrate with Concourse CI to enable credential generation and storage in CredHub. Additional information can be [found here.](http://concourse.ci/creds.html#credhub)

    **Status**: Released in Concourse v3.5.0

* **Provide performance results for horizontally scaled instances**

    The goal of this initiative is to provide performance results for CredHub as it is scaled to multiple instances. Additional information can be [found here.](performance-testing.md)

    **Status**: Completed

* **CredHub should support BBR for backing up and restoring its database**

    The goal of this initiative is to allow users of [BBR](https://github.com/cloudfoundry-incubator/bosh-backup-and-restore) to backup and restore the CredHub database using the BBR utility. Additional information can be [found here.](https://github.com/pivotal-cf/credhub-release/blob/master/docs/backup-restore-recommendations.md)

    **Status**: Released in v1.3.0
