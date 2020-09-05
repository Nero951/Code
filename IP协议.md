**IP协议**

![image-20200903003019764](C:\Users\Wade Winston Wilson\AppData\Roaming\Typora\typora-user-images\image-20200903003019764.png)

路由就是选路问题。

路由器就是能解决路由的角色。

Internet Protocol : 主要有两大类

ipv4 : 4个字节，如：192.168.135.188

ipv6 : 6个字节

![image-20200903211102985](C:\Users\Wade Winston Wilson\AppData\Roaming\Typora\typora-user-images\image-20200903211102985.png)

![](C:\Users\Wade Winston Wilson\AppData\Roaming\Typora\typora-user-images\image-20200903211130977.png)

IP地址(网络号 + 主机号组成) 类似身份证

  ip1 和 ip2 相遇时，如果主机号相同，就表示我们在同一个网络(子网)。

![image-20200903212640725](C:\Users\Wade Winston Wilson\AppData\Roaming\Typora\typora-user-images\image-20200903212640725.png)

![image-20200903213245717](C:\Users\Wade Winston Wilson\AppData\Roaming\Typora\typora-user-images\image-20200903213245717.png)

![](C:\Users\Wade Winston Wilson\AppData\Roaming\Typora\typora-user-images\image-20200903214111201.png)

![image-20200903214140818](C:\Users\Wade Winston Wilson\AppData\Roaming\Typora\typora-user-images\image-20200903214140818.png)

静态划分的方法已经过时了，现在已经不用了。

![image-20200903221915522](C:\Users\Wade Winston Wilson\AppData\Roaming\Typora\typora-user-images\image-20200903221915522.png)

![image-20200903222645938](C:\Users\Wade Winston Wilson\AppData\Roaming\Typora\typora-user-images\image-20200903222645938.png)

![image-20200903223642016](C:\Users\Wade Winston Wilson\AppData\Roaming\Typora\typora-user-images\image-20200903223642016.png)

使用 route print -4 查看IPV4路由表。

![image-20200903231259241](C:\Users\Wade Winston Wilson\AppData\Roaming\Typora\typora-user-images\image-20200903231259241.png)

如果(目标&网络掩码==网络目标){找到了}

![image-20200904205414480](C:\Users\Wade Winston Wilson\AppData\Roaming\Typora\typora-user-images\image-20200904205414480.png)

![image-20200904205554960](C:\Users\Wade Winston Wilson\AppData\Roaming\Typora\typora-user-images\image-20200904205554960.png)

![image-20200904205906996](C:\Users\Wade Winston Wilson\AppData\Roaming\Typora\typora-user-images\image-20200904205906996.png)

cmd指令输入arp 查看指令。

![image-20200904212836470](C:\Users\Wade Winston Wilson\AppData\Roaming\Typora\typora-user-images\image-20200904212836470.png)

过程。

TCP三次握手过程，来自应用层的依据命令。但中间不需要应用层过问，提供给应用层是最终建立好的连接。

无论数据来自哪里，达到互联网上的其他设备时，都是被中间的路由器们一跳一跳的传递过去的。

来时的路，不一定是回去的路。

应用层使用TCP时，一旦开始写数据了，一定是建立在三次握手后的连接上。

![image-20200904214615231](C:\Users\Wade Winston Wilson\AppData\Roaming\Typora\typora-user-images\image-20200904214615231.png)

![image-20200904214809251](C:\Users\Wade Winston Wilson\AppData\Roaming\Typora\typora-user-images\image-20200904214809251.png)

例题：一个IP划分6个子网，子网中主机数量最大有26台：

![image-20200904221618128](C:\Users\Wade Winston Wilson\AppData\Roaming\Typora\typora-user-images\image-20200904221618128.png)

浏览器原理？