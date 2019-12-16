PREREQUISITES<br>
- Java 12 installed
- Maven installed - how to: https://maven.apache.org/install.html
- Chrome v. 79

To execute the tests with default values: continent=Europe, country=Romania, language=English:<br>
1. unzip gopro.zip
2. open command line in root folder
3. mvn test -Ptest

To execute the tests with specific values:
- mvn test -Ptest -Dcontinent=Europe -Dcountry=germany -Dlanguage=english 

Reports:
- general reports: gopro\target\surefire-reports\index.html
- junit xml report: gopro\target\surefire-reports\junitreports
