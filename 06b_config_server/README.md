This is a project to test the config server part

The config can be pulled from either the local git repo or from the remote git repo

In this case local git repo is used. Need to have a separate git repo and all the properties files should be committed only then the spring config server will read.

The properties files in the repo can be of these formats

	{application name}-{profile}.properties
	application.properties
	application-{profile}.properties
	
Generally in the microservices, each microservice will have a unique name. So any consumer for this config server will have a name and that is what we refer to {application name} here. The application name for the consumer can be set in the consumer side using 'spring.application.name' property.

For example, the git server can have the files like these

		application-dev.properties
		application-prod.properties
		application.properties
		my-test-service-dev.properties
		my-test-service-prod.properties
		my-test-service.properties

Where my-test-service is consumer application specific configuration files and application-{profile}.properties files are global files which are common to any consumer. 