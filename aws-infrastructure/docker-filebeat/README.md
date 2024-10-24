# Push image to ECR
Run below commands to push our custom Filebeat image to ECR.
```
aws ecr get-login-password --region eu-central-1 --profile backend-test | docker login --username AWS --password-stdin 897729126232.dkr.ecr.eu-central-1.amazonaws.com
```

```
docker build -t filebeat-custom .
```

```
docker tag filebeat-custom 897729126232.dkr.ecr.eu-central-1.amazonaws.com/monitoring:filebeat
```

```
docker push 897729126232.dkr.ecr.eu-central-1.amazonaws.com/monitoring:filebeat
```