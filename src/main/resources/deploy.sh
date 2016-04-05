#!/bin/bash

 if [ -z "$1" ] || [ -z "$2" ] || [ -z "$3" ]; then
     echo "Usage : ./deploy.sh ch_01 uc_01 <ESB_HOME>"
     exit 0
 fi


config="${1}/${2}/synapse-configs"
esb_dep="${3}/repository/deployment/server"

cp -r $config $esb_dep

echo "ESB config : $config copied to : $esb_dep"
