pipeline {
    agent any

    stages {

        stage('Checkout Source Code') {
            steps {
                git 'https://github.com/AshishMaurya93/amazon-selenium-grid.git'
            }
        }

        stage('Start Selenium Grid') {
            steps {
                sh 'docker-compose up -d'
            }
        }

        stage('Run Automation Tests') {
            steps {
                sh 'mvn clean test'
            }
        }
    }

    post {
        always {
            echo "Test Execution Completed"
            sh 'docker-compose down'
        }
    }
}
