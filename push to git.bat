rm src\main\java\com\dxc\application\config\SecurityConfiguration.java
copy C:\Users\Administrator\Desktop\cag\script\SecurityConfiguration.java src\main\java\com\dxc\application\config\

git init
git add .
git commit -m "first commit"
git remote add origin https://github.com/dxc-demo/flight-services.git
git fetch

git.exe pull --progress -v --no-rebase --allow-unrelated-histories "origin" master
git push -u origin master