# isMedia

## Software Introduction
isMedia, named after intelligent self-media, is a one-stop video management platform for self-publishers. We are pleased to introduce you to this product, which is designed to allow self-publishers to easily upload their work to various self-publishing sites with one click, and to easily edit and The product is currently available in v1.0. Currently in v1.x, the software is planned to have access to YouTube and Bilibili, with Bilibili being integrated. In v1.x, the software will be used from the command line, but in future versions we will gradually add a desktop UI to make it easier for users to use.

## Operating environment
The software runs on PCs with Windows 10 and above on x64 platforms. For the software to run stably, we recommend that you have the following minimum computer configuration requirements.
- CPU: Intel Core i3 7100 and other products of the same performance 
- Memory: DDR3 1600mHz 4GB
- Disk space: minimum 500MB of disk space reserved

## How to use

Please [download the latest version](https://github.com/Bornya/isMedia/releases) of the software from the software download page and extract it to a folder, and then run Powershell or cmd from that folder.
Under the current version (v1.0.0), the individual functional commands of isMedia are as follows.

1. Add an account

You can use the command
```
isMedia.exe -a --platform [youtube][bilibili] [--user] [xxxxx@gmail.com] [--proxy- host][${your_proxy_host}][--proxy-port][${your_ proxy_port}]
```
to add your self-publishing video account to isMedia. note that isMedia uses the OAuth protocol for login and does not store your username and password. After using this command you will be given a login link, please open this link in your browser to complete the account addition.

2、Upload video

You can use
```
isMedia.exe -u --platform [youtube][,][bilibili][all] [--user] [xxxxx@gmail. com] -video "${video_body}" [--proxy-host][${your_proxy_host}][--proxy-port][${your_proxy_port}]
```
to upload the video. 

If the account name you specify has been added to isMedia, the video will be uploaded directly if your network environment is working. If you have specified multiple platforms or special all keywords, the video will be uploaded to multiple self-publishing platforms.

Here I will introduce you to the video body of the command, where we describe a video using a string in json format, which roughly looks like the following format.
```
{
 	'title': 'your video title', 
 	'description': 'your video description', 
 	'localMediaPath': 'the video path on your computer', 
 	'tags':['tag_a', 'tag_b', 'and so on '], 
 	'privacyStatus': 'public or private'
}
```
For compatibility with cmd's parsing of arguments, we replace all the places that should be double quotes with single quotes, or if you do need to use quotes, use 
```\"``` or ```\'```. 

Finally, remove all line breaks and replace ```${video_body}``` with them in the command.

3、For more help please use the command ```isMedia.exe -h/--help```
 
## Future version development plans

1.	In v1.x, we will continue to integrate the Bilibili platform and add new video management features (such as video list view, etc.)
2.	In v2.x, we plan to introduce a desktop UI for easier management of self-published videos and integration with more self-published video platforms.
3.	In v3.x version, we will plan to add visualisation of creator and video data (number of likes, plays, comments, etc.) and make some intelligent operational recommendations to truly realise an intelligent self-publishing video management system.

## Careers

We are excited to let you know that we have open sourced this product, it has been published on GitHub at [Bornya/isMedia](https://github.com/Bornya/isMedia) under the ```Apache License 2.0```, and it is developed in ```Java```. If you are a developer, feel free to fork, star and create pull requests.

<font color=FF0000>Risk warning: If we are asked by major self-publishing platforms to stop open-sourcing the product for reasons such as user data security, we will regretfully close the software repository, after which the software copyright and ownership will belong to Bornya Studio, and we will then compensate the contributors for this.</font>

## Any questions

You are welcome to submit your question on the [issues page](https://github.com/Bornya/isMedia/issues) of our project. When submitting your question we recommend that you include command line input and output to help us locate the problem.

## Software Downloads

You can download the latest version of the software by clicking on the following link. 
- [latest release v1.0.0](https://github.com/Bornya/isMedia/releases)

