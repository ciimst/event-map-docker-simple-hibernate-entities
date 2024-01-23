pipeline {

    agent any

    tools {

        maven "maven 3.5.0"

    }


    stages {

        stage("Clone code from VCS") {

            steps {

                script {

                    checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: '13daaff0-994d-486d-8d1b-0f050daeeb26', url: 'https://github.com/ciimst/event-map-docker-simple-hibernate-entities.git']])		    
	        
        sh 'mvn wrapper:wrapper'
		/*sh './mvnw clean compile'*/
                sh 'mvn clean install'
		  
                }

            }

        }

        //stage("Maven Build") {

          //  steps {

            //    script {
                    //sh 'mvn install clean'
                    //sh "mvn clean package -DskipTests=true"

            //    }

          //  }

       // }

         stage("Publish to Nexus Repository Manager") {
            steps {
                script {
                    pom = readMavenPom file: "pom.xml";
                    filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
                    echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"
                    artifactPath = filesByGlob[0].path;
                    artifactExists = fileExists artifactPath;
                    if(artifactExists) {
                        echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";
                        nexusArtifactUploader(
                            nexusVersion: 'nexus3',
                            protocol: 'http',
                            nexusUrl: '177.177.0.236:8081',
                            groupId: 'com.imst.event.map.hibernate',
                            version: '1.4.30',
                            repository: 'event-map-hibernate-entities',
				//repository: 'maven-public',
                            credentialsId: 'nexus',
                            artifacts: [
                                [artifactId: 'event-map-docker-simple-hibernate-entities',
                                classifier: '',
                                file: artifactPath,
                                type: pom.packaging],
                                [artifactId: 'event-map-hibernate-entities',
                                classifier: '',
                                file: "pom.xml",
                                type: "pom"]
                            ]
                        );
                    } else {
                        error "*** File: ${artifactPath}, could not be found";
                    }
                }
            }
        }

        

    }

}
