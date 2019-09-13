pipeline {
    agent {
        node {
            label 'nodejs'
        }
    }
    options {
        timeout(time: 20, unit: 'MINUTES')
    }
    stages {
        stage('prepare') {
            steps {
                script {
                    openshift.withCluster() {
                        openshift.withProject() {
                            echo "prepare"
                            echo "Using project: ${openshift.project()}"
                        }
                    }
                }
            }
        }
        stage('clone') {
            steps {
                script {
                    echo "clone"
                }
            }
        }
        stage('prebuild') {
            steps {
                script {
                    echo "prebuild"
                }
            }
        }
        stage('build') {
            steps {
                script {
                    //expo build apk
                    echo "build"
                }
            }
        }
        stage('distribute') {
            steps {
                script {
                    echo "distribute"
                }
            }
        }
    }
}