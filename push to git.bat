
git init
git add .
git commit -m "first commit"
git remote add origin https://github.com/dxc-demo/flight-services.git
git fetch
cls
git.exe pull --progress -v --no-rebase --allow-unrelated-histories "origin" master
git push -u origin master