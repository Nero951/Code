#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//int main()
//{
	//printf("hello,\nplease input some numbers to add:");
	//int a = 0;
	//int b = 0;
	//int c = 0;
	//scanf("%d", &a);
	//scanf("%d", &b);
	//c = a+b;
	//printf("%d\n",a+b);
	//char arr1[] = "abc";
	//char ar2[] = { 'a','b','c' };
	//printf("%s\n", arr1);
	//printf("%s\n", arr2);
	//printf("%d\n", strlen(ar2));
	//printf("\a\a\a\a\a\a\a\a\a");
	//printf("%d\n", strlen("c:\text\32\text.c"));
	//int a = 0;
	//int b = 0;
	//int c = 0;
	//printf("请输入数值进行计算：\n");
	//scanf("%d", &a);
	//scanf("%d", &b);
	//c = a + b;
	//while (c < 100)
	//{
	//	printf("继续计算:%d,%d,%d\n",a,b,c);
	//	a++;
	//	b++;
	//	c = a + b;
	//}
	//printf("达到上限:%d\n");

	//if (c < 100)
	//	printf("未达到上限值：%d\n", c);
	//else
	//	printf("已超过最大值：%d\n", c);
	//int arr1[40] = { 1,1,2,3,4,5,6,7 };
	//int sz = sizeof arr1 / sizeof arr1[0];
	//printf("%d\n", sizeof arr1);
	//printf("%d\n", sz);

	//return 0;
//}


//int MAX(int x, int y,int z)
//	{
//	if (x > y)
//		return (z > y ? z : y);
//	else
//		return (z > x ? z : x);
//	}
//int main()
//{
//		int a = 10;
//		int b = 9;
//		int max = 0;
//		max = MAX(a,b);
//		printf("%d\n",max);
//		return 0;
//}

//int main()
//{
//	int x = 1;
//	int a = 0;
//	while (x <= 100)
//	{
//		if (x % 2 == 1)
//
//
//			printf("奇数%d\n", x);
//		else
//		{
//			printf("偶数%d\n", x);
//		//	a++;
//		//	a = x + a;
//		//	printf("%d\n",a);
//		}
//		x++;
//	//	x += 2;
//	}
//	return 0;
//}
//
//int main()
//{
//	int a = 1;
//	while (a <= 100)
//	{
//		if (a % 3 == 0)
//			printf("%d\n", a);
//		a++;
//	}
//	return 0;
//}
//int main()
//{
//	int a = 0;
//	int b = 0;
//	scanf("%d%d", &a, &b);
//	int c = (b > a ? a : b);
//	
//	while (1)
//	{
//	
//		if (a%c == 0 && b%c == 0)
//		{
//			printf("%d\n", c);
//			break;
//		}
//	 c--;
//	}
//	
//	return 0;
//}
//求闰年
//int main()
//{
//	int year = 1000;
//	while (year <= 2000)
//	{
//		if (year % 4 == 0 && year % 100 != 0)
//		{
//			printf("闰年：%d\n", year);
//		}
//		else if (year % 400 == 0)
//		{
//			printf("闰年：%d\n", year);
//		}	
//		year++;
//	}
//	return 0;
//}
//int main()
//{
//	int a = 0;
//
//	return 0;
//}
//int par(int a, int b, int c)
//{
//	if (a > b)
//	{
//		printf("%d\n", a);
//		if (b > c)
//			printf("%d\n%d\n", b, c);
//		else
//			printf("%d\n%d\n", c, b);
//	}
//	else
//	{
//		printf("%d\n", b);
//		if (a > c)
//		{
//			printf("%d\n", a);
//			printf("%d\n", c);
//		}
//		else
//		{
//			printf("%d\n", c);
//			printf("%d\n", a);
//		}
//	}
//	return par;
//}
//int main()
//{
//	int a = 17;
//	int b = 16;
//	int c = 12;
//	printf("%d%d%d", par(a, b, c));
//	return 0;
//}
//将三个数从大到小排列
//int main()
//{
//	int a = 0;
//	int b = 0;
//	int c = 0;
//	int k = 0;
//	scanf("%d%d%d", &a, &b, &c);
//	if (a < b)
//	{
//		k = a;
//		a = b;
//		b = k;
//	}
//	if (a < c)
//	{
//		k = a;
//		a = c;
//		c = k;
//	}
//	if (b < c)
//	{
//		k = b;
//		b = a;
//		a = k;
//	}
//	printf("%d%d%d\n", a, b, c);
//	return 0;
//}
//求100-200之间的素数
//int main()
//{
//	int a = 100;
//	
//	while (a <= 200)
//	{
//        int j = 2;
//		while (j < a)
//		{
//
//			if (a%j == 0)
//			{
//				break;
//			}
//			j++;
//		}
//		if (a == j)
//		{
//			printf("素数：%d", a);
//		}
//		a++;
//	}
//	return 0;
//}


