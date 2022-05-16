#!/bin/sh
oriBran=$(git name-rev --name-only HEAD) # 获取当前远程分支名字
echo "当前分支：$oriBran" #remotes/origin/main_DEALER-2932

gitBran=$1 # 本地分支
echo "gitBran=$gitBran"
workDir=$2
outDir=$3
echo "workDir=$workDir"
echo "outDir=$outDir"

echo "start checkout--"
git checkout -b ${gitBran} origin/$gitBran
git checkout -f ${itBran}

echo "start pull--"
git pull

echo "start copy: cp -r "${workDir}/app/classes" ${outDir} "
cp -r "${workDir}/app/classes" ${outDir}

echo "copy over --"