#!/bin/bash

 if [ -z "$1" ] || [ -z "$2" ]; then
     echo "Usage : ./deploy.sh ch_01 <ESB_HOME>"
     exit 0
 fi


config="${1}/synapse-configs"
esb_dep="${2}/repository/deployment/server"

cp -r $config $esb_dep

echo "ESB config : $config copied to : $esb_dep"
