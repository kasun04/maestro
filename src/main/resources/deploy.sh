#!/bin/bash

 if [ -z "$1" ] || [ -z "$2" ] || [ -z "$3" ]; then
     echo "Usage   : ./deploy.sh <chapter_name> <usacase_name> <root directory of your WSO2 ESB installation>"
     echo "Example : ./deploy.sh ch_02 uc_01 /Users/kasun/development/deployment/maestro/wso2esb-5.0.0"
     exit 0
 fi

static_config="${1}/resources/config"
mediation_config="${1}/${2}/synapse-configs"

esb_static_config="${3}/repository/conf"
esb_dep="${3}/repository/deployment/server"

sample_resources="${1}/resources/sample_resources"
esb_sample_resources="${3}"

if [ -d "$static_config" ]; then
  # static configuration found and using it for ESB
  cp -rf -v $static_config/* $esb_static_config
  echo "ESB static config : $static_config copied to : $esb_static_config"
fi

if [ -d "$sample_resources" ]; then
  # Resources configuration found and using it for ESB
  cp -rf -v $sample_resources $esb_sample_resources
  echo "ESB static config : $sample_resources copied to : $esb_sample_resources"
fi

cp -rf -v $mediation_config $esb_dep
echo "ESB Mediation Config : $mediation_config copied to : $esb_dep"
