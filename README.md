# # SpringFileApi

# What is this?
An API that receives and stores an image file from a client

Base on SpringBoot 3. & MySQL

# How To Use This?

### When Upload Image file

1. Upload an image file through request body  (The Key's value should be "image" )
2. When the Request was processed Successfully:
	API Reponses "file upload success + [Directory of the image where it was saved]" message!

<img width="80%" src="https://raw.githubusercontent.com/bell-person-ii/SpringFileApi/main/images/%ED%8C%8C%EC%9D%BC%EC%97%85%EB%A1%9C%EB%93%9C%20%EB%8D%B0%EB%AA%A8.png"/>
 when the image is uploaded to API, an UUID is allocated to the image. And it's saved with it's upload-name, UUID and file path in the DataBase
<br/>
<br/>
<img width="80%" src="https://raw.githubusercontent.com/bell-person-ii/SpringFileApi/main/images/%EC%97%85%EB%A1%9C%EB%93%9C%20%EB%8D%B0%EB%AA%A8%20DB.png"/>

* * * 


### when Download Image file
1.  Request the image file through url [~~/fileSystem/{file_name.(extension)}]
2. If the image you requested is Exist, API Returns it Through ResponseBody!

<img width = "80%" src="https://raw.githubusercontent.com/bell-person-ii/SpringFileApi/main/images/%EB%8B%A4%EC%9A%B4%EB%A1%9C%EB%93%9C%20%EB%8D%B0%EB%AA%A8.png">
