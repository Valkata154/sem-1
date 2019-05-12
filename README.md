#Software Engineering Methods

- Master Build Status [![Build Status](https://travis-ci.org/tsarevpp/sem.svg?branch=master)](https://travis-ci.org/tsarevpp/sem)
- Develop Build Status [![Build Status](https://travis-ci.org/tsarevpp/sem.svg?branch=develop)](https://travis-ci.org/tsarevpp/sem)
- License [![LICENSE](https://img.shields.io/github/license/tsarevpp/sem.svg?style=flat-square)](https://github.com/tsarevpp/sem/blob/master/LICENSE)
- Release [![Releases](https://img.shields.io/github/release/tsarevpp/sem/all.svg?style=flat-square)](https://github.com/tsarevpp/sem/releases)
- Code Coverage [![codecov](https://codecov.io/gh/tsarevpp/sem/branch/master/graph/badge.svg)](https://codecov.io/gh/tsarevpp/sem)

Usage:
 Stop running docker containers and delete app and db images.
 - Open Maven panel on the right
 - Click Compile, wait to finish
 - Click Package, wait to finish
 - In terminal, run "docker-compose run app"
 - Profit
 
 25 requirements of 32 have been implemented, which is 78.13%.
 
 
 | ID  | Name          | Met           | Screenshot     |
  | ---|:-------------:| -------------:| --------------:|
  | 1  | Generate report with the population of a city |          Yes |       ![pic](./img/1.PNG)     |
  | 2  | Generate report with the population of a district |          Yes |           ![pic](./img/2.PNG) |
  | 3  | Generate report with the population of a country|          Yes |           ![pic](./img/3.PNG) |
  | 4  | Generate report with the population of a region |          Yes |           ![pic](./img/4.PNG) |
  | 5  | Generate report with the population of a continent |          Yes |           ![pic](./img/5.PNG)|
  | 6  | Generate report with the population of the world |          Yes |           ![pic](./img/6.PNG) |
  | 7  | Generate report with the population of people, people living in cities, and people not living in cities in each country |          Yes |           ![pic](./img/3.PNG) |
  | 8  | Generate report with the population of people, people living in cities, and people not living in cities in each region |          Yes |           ![pic](./img/4.PNG) |
  | 9  | Generate report with the population of people, people living in cities, and people not living in cities in each continent |          Yes |           ![pic](./img/5.PNG) |
  | 10 | Generate report with the top N populated cities in a district where N is provided by the user |          Yes |           ![pic](./img/10.PNG) |
  | 11 | Generate report with the top N populated cities in a country where N is provided by the user. |          Yes |           ![pic](./img/7-11.PNG) |
  | 12 | Generate report with the top N populated cities in a region where N is provided by the user |          Yes |           ![pic](./img/8-12.PNG) |
  | 13 | Generate report with the top N populated cities in a continent where N is provided by the user |          Yes |           ![pic](./img/9-13.PNG) |
  | 14 | Generate report with the top N populated cities in the world where N is provided by the user |          Yes |           ![pic](./img/14.PNG) |
  | 15 | Generate report with the top N populated countries in a continent where N is provided by the user |          Yes |           ![pic](./img/15-18.PNG) |
  | 16 | Generate report with the top N populated countries in the world where N is provided by the user |          Yes |           ![pic](./img/16-19.PNG) |
  | 17 | Generate report with all the countries in a region organised by largest population to smallest |          Yes |           ![pic](./img/17-20.PNG) |
  | 18 | Generate report with all the countries in a continent organised by largest population to smallest |          Yes |           ![pic](./img/15-18.PNG) |
  | 19 | Generate a report with all the countries in the world organised by largest population to smallest |          Yes |           ![pic](./img/16-19.PNG) |
  | 20 | Generate report with the top N populated countries in a region where N is provided by the user. |          Yes |           ![pic](./img/17-20.PNG) |
  | 21 | Generate report for Arabic |          Yes |           ![pic](./img/21.PNG) |
  | 22 | Generate report for Spanish |          Yes |           ![pic](./img/22.PNG) |
  | 23 | Generate report for Hindi |          Yes |           ![pic](./img/23.PNG) |
  | 24 | Generate report for English |          Yes |           ![pic](./img/24.PNG) |
  | 25 | Generate Report for Chinese |          Yes |           ![pic](./img/25.PNG) |
  | 26 | Generate report with the top N populated capital cities in a region where N is provided by the user |          No |           - |
  | 27 | Generate report with the top N populated capital cities in a continent where N is provided by the user |          No |           - |
  | 28 | Generate report with the top N populated capital cities in the world where N is provided by the user |          No |           - |
  | 29 | Generate report with all the capital cities in a region organised by largest to smallest |          No |           - |
  | 30 | Generate report with all the capital cities in a continent organised by largest population to smallest. |          No |           - |
  | 31 | Generate report with all the capital cities in the world organised by largest population to smallest |          No |           - |
  | 32 |           |           |            |
 
 
 
 
 
 
 
 |                 | Code Review 1 | Code Review 2 | Code Review 3  | Code Review 4  | Final Deliverable | Average        |
 | ----------------|:-------------:| -------------:| --------------:| --------------:| -----------------:| --------------:|
 | Andrey Tsarev   |          0.25 |          0.25 |           0.25 |           0.50 |               0.4 |           0.33 |
 | Albert Jacmenov |          0.25 |          0.25 |           0.25 |          0.167 |               0.2 |          0.223 |
 | Martin Lipchev  |          0.25 |          0.25 |           0.25 |          0.167 |               0.2 |          0.223 |
 | Marcos De Faria Perez|     0.25 |          0.25 |           0.25 |          0.167 |               0.2 |          0.223 |
