#!/bin/bash

config="${1}/synapse-configs"

echo $1

cp -r $config /Users/kasun/development/deployment/WEIA/wso2esb-4.9.0-M8-SNAPSHOT/repository/deployment/server

echo "ESB config : $config copied."
