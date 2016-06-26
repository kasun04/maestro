#!/bin/bash

 if [ -z "$1" ] || [ -z "$2" ] || [ -z "$3" ]; then
     echo "Usage : ./deploy.sh ch_01 uc_01 <ESB_HOME>"
     exit 0
 fi

static_config="${1}/config"
mediation_config="${1}/${2}/synapse-configs"

esb_static_config="${3}/repository/conf"
esb_dep="${3}/repository/deployment/server"

if [ -d "$static_config" ]; then
  # static configuration found and using it for ESB
  cp -r $static_config $esb_static_config
  echo "ESB static config : $static_config copied to : $esb_static_config"
fi

cp -r $mediation_config $esb_dep
echo "ESB Mediation Config : $mediation_config copied to : $esb_dep"
