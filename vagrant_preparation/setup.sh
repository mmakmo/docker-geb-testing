#!/bin/bash

BASE_DIR=$(cd $(dirname $0)/..;pwd)
BOX_DIR=${HOME}/.vagrantbox
SDELETE_DIR=${BASE_DIR}/SDelete

if [ ! -d "${BOX_DIR}" ]; then
    mkdir ${HOME}/.vagrantbox
fi

cd ${BOX_DIR}
curl -o win10_edge.zip https://az792536.vo.msecnd.net/vms/VMBuild_20171019/Vagrant/MSEdge/MSEdge.Win10.Vagrant.zip
unzip -o win10_edge.zip
mv "MSEdge - Win10.box" original_win10_edge.box
rm ${BOX_DIR}/*.zip

cd ${SDELETE_DIR}
rm ./*.exe ./*.txt
curl -o SDelete.zip https://download.sysinternals.com/files/SDelete.zip
unzip -o SDelete.zip
rm SDelete.zip

cd ${BASE_DIR}

vagrant plugin update
vagrant up
