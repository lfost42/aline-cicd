#! /bin/bash
for name in "APP_VPC" "APP_LB" "LOAD_BALANCER" "DB_USERNAME" "DB_HOST" "DB_PORT" "DB_NAME" "ACCOUNT_PORT" "BANK_PORT" "CARD_PORT" "GATEWAY_PORT" "TRANSACTION_PORT" "UNDERWRITER_PORT" "USER_PORT"
do
  value=$(aws ssm get-parameters --names $name --with-decryption --query Parameters[0].Value --output text)
  echo "$name=$value" >> .env_ecs
done