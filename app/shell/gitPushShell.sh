#!/bin/sh
oriBran=$(git name-rev --name-only HEAD)
echo $oriBran #remotes/origin/main_DEALER-2932


array=(${oriBran//// })
length=${#array[@]} # 数组长度
gitBran=${array[length-1]} # 本地分支
echo "gitBran=$gitBran"

#git stash clear
#git stash
#
#echo "start checkout--"
#git checkout -b $gitBran $oriBran
#git checkout -f $gitBran #强制切换分支，会丢失工作区的修改
#
#git pull
#
#git stash pop #取出

echo "start add -f app/classes/--"
git add -f /Users/joyme/Desktop/android_workspace/AndJacoco/app/classes
#git add -f app/classes/

echo "start commit -- commit -am $1"
git commit -am "$1"

echo "start push --"
git push origin $gitBran
#echo "push origin $gitBran $oriBran"
#git push origin $gitBran $oriBran
#echo "start push again--"
#echo "push origin $gitBran:$oriBran"
#git push origin $gitBran:$oriBran

echo "end push --"