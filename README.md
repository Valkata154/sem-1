#Software Engineering Methods

- Master Build Status [![Build Status](https://travis-ci.org/tsarevpp/sem.svg?branch=master)](https://travis-ci.org/tsarevpp/sem)
- Develop Build Status [![Build Status](https://travis-ci.org/tsarevpp/sem.svg?branch=develop)](https://travis-ci.org/tsarevpp/sem)
- License [![LICENSE](https://img.shields.io/github/license/tsarevpp/sem.svg?style=flat-square)](https://github.com/tsarevpp/sem/blob/master/LICENSE)
- Release [![Releases](https://img.shields.io/github/release/tsarevpp/sem/all.svg?style=flat-square)](https://github.com/tsarevpp/sem/releases)

Usage:
0. Stop running docker containers and delete app and db images.
1. Open Maven panel on the right
2. Click Compile, wait to finish
3. Click Package, wait to finish
4. In terminal, run "docker-compose up"
5. Wait at least 2 minutes
6. Profit 

If that didn't work:
1. "git rm --cached db/test_db"
2. "git submodule add https://github.com/datacharmer/test_db db/test_db"
3. "git submodule init"
4. "git submodule update"

If it still doesn't work:
1. Go to Settings -> Version Control
2. Click the Plus button on the right
3. Click on directory and select db/test_db
4. Delete docker images and containers and run again