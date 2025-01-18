pipeline { // must be top-level
	agent any // where to execute
	parameters { //Parameterize your Build
		string(name: 'VERSION', defaultValue: '', description: 'version to deploy on prod.')
		choice(name: 'VERSION', choices: ['1.1.0','1.2.0','1.3.0'], description: "")
		booleanParam(name:'executeTests', defaultVale: true, description: '')
	}
	tools { // Access build tools for you project
		gradle 'Gradle'
	}
	environment { // can get access environment variable in all stages.
		NEW_VERSION = '1.3.0'
		SERVER_CREDENTIALS = credentials('87e0d222-48f3-4f16-a743-d371538f1236')
	}
	stages { // where the "work" happens
		
		stage("build") {
			steps {
				echo "building version ${NEW_VERSION}"
				echo 'building the application...'
				gradle build
			}
		}
		
		stage("test") {
			when { //Only if this condition is true go to the steps.
				allOf {
					params.executeTests
					expression {
						BRANCH_NAME == 'master' || BRANCH_NAME == 'dev'
					}
				}
			}
			steps {
				echo 'testing the application...'
			}
		}
		
		stage("deploy") {
			
			steps {
				echo 'deploying the application...'
				echo "deploying with credentials ${SERVER_CREDENTIALS}"
				withCredentials([
					usernamePassword(credentials: '87e0d222-48f3-4f16-a743-d371538f1236', usernameVariable: USER, passwordVariable: PWD)
				]){
					//sh "some script ${USER} ${PWD}"
					echo "${USER} ${PWD}"
				}
				echo "deploying version ${params.VERSION}"
			}
		}
	}
	post { // execute some login AFTER all stages executed
		always {
			
		}
		success {
			
		}
		failure {
			
		}
	}
}