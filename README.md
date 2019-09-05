c# Windows-Directory-Path-Traversal

The service should provide a method to do the following:
Given a full path to a directory as a parameter, return an XML that contains description of all the files and directories (recursively) sorted in natural order under the one given as the parameter. The description must include a full path, size and a flag if the entry is a directory or a file. 


## Project Consist below 3 packages 

```bash
#For Main logic
package com.rahul.rawat.assignment
package com.rahul.rawat.exception

#For Unit Test cases
package com.rahul.rawat.test;
```

## 1.	To build and execute unit-test-cases

[Project code link](https://github.com/RahulSinghRawat/WindowsDirectoryPathTraversal.git)

```python
     1. Clone the project from above link.
     2. Navigate to project pom.xml location.
     3. mvn clean install
```
## 2. Output xml file generates under 
```python
     folder :  src\resources
```
## Contributing
Pull requests are welcome. For major changes, please do proper comment and discuss what you would like to change.

Please make sure to update tests as appropriate.
