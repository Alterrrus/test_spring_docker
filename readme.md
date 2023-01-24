1. ***for snap/flatpack ide jetbrains override file system to docker socket connect(linux)***
<br>`~$ flatpak list   # get the list of applications and Application ID`</br>
<br>`~$ flatpak override --user --filesystem=/run/docker.sock com.jetbrains.PyCharm-Professional  # the equivalent for pycharm professional edition`</br>
<br>`~$ flatpak override --user --filesystem=/run/docker.sock com.jetbrains.IntelliJ-IDEA-Ultimate`</br>
2. ***include "no sudo" for docker (linux)***
3. ***test url template apply without base api url***
