# Java Environment Setup

1. Close all VSCode windows
2. Close Command prompts or Powershell
3. Start Menu > type "ENV" > choose "Edit Env Vars for YOUR ACCOUNT"
4. Click on NEW > 

        Variable Name : JAVA_HOME (Case Sensitive)
        Value : C:\Program Files\Microsoft\jdk-11.0.21.9-hotspot 

        > My JDK Installation path is different as I am using Microsoft JDK

5. Click OK/Save

6. Download Apache Maven https://dlcdn.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.zip 

7. After Download is finished, open the ZIP file and "Extract All" to "C:\"

8. After Extraction a new folder must be created C:\apache-maven-3.9.6

9. Verify if the folder C:\apache-maven-3.9.6 contains licence, readme file and folder like bin

10. Open "bin" folder and copy the PATH of bin folder

11. Start Menu > ENV > choose "Edit Env Vars for YOUR ACCOUNT" 
	Double click on "PATH" variable, then click "New" and add new path
	C:\apache-maven-3.9.6\bin	