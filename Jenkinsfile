

pipeline {
  agent any
  environment {
    imageName = 'springboot-demo'
    imageTag = "v1.0"
    harbor_domain = '192.168.0.100:10010'
    harbor_user = 'admin'
    harbor_pwd = 'pwdxd12345'
  }
  
  
  stages {

    stage('Build') {
      steps {
		// 使用Maven进行构建，跳过测试
		sh "mvn clean package -DskipTests"

      }
    }

    stage('Build Image') {
      steps{
        script {
          // 构建Docker镜像
          sh "docker build -t ${imageName}:${imageTag} ."
        }
      }
    }

    stage('Push Image') {
      steps{
        script {
		  
            // 登录Harbor
            sh "docker login -u ${harbor_user} -p ${harbor_pwd} ${harbor_domain}"
			
			//重命名
			sh "docker tag ${imageName}:${imageTag} ${harbor_domain}/cicd/${imageName}:${imageTag}"

            // 推送镜像
            sh "docker push ${harbor_domain}/cicd/${imageName}:${imageTag}" 
        }  
      }
    }
	
	// 新增阶段：创建并存档 trigger.properties
    stage('Archive Properties') {
      steps {
        script {
          sh '''
            echo "imageName=$imageName" > trigger.properties
            echo "imageTag=$imageTag" >> trigger.properties
            echo "harborDomain=$harbor_domain" >> trigger.properties
            echo "fullImageAddress=$harbor_domain/cicd/$imageName:$imageTag" >> trigger.properties
          '''
          archiveArtifacts artifacts: 'trigger.properties'
        }
      }
    }

  }
}