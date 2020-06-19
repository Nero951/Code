#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//char Inver(char* arr)
//{
//	int len = strlen(arr);
//	char* left = 0;
//	char* right = len - 1;
//	while (left < right) 
//	{
//		char* temp = left;
//		left = right;
//		right = temp;
//		left++;
//		right--;
//	}return(*arr);
//}
//int main()
//{
//	char arr[] = "hello";
//	Inver(arr);
//	printf("%s\n", arr);
//	return 0;
//}
//int main()
//{
//
//	return 0;
//}
//int Def(int x, int y)
//{
//	int i = x ^ y;
//	int count = 0;
//	while (i != 0) 
//	{
//		i=i&(i-1);
//		count++;
//	}
//	return count;
//}
//int main()
//{
//	int a = 0;
//	int b = 0;
//	scanf("%d%d", &a, &b);
//	int c = Def(a, b);
//	printf("%d\n", c);
//	return 0;
//}
//void Math(int n)
//{
//	for (int i = 31; i >= 1; i -= 2)
//	{
//		printf("%d", (n >> i) & 1);
//	}
//	printf("\n");
//	for (int i = 30; i >= 2; i -= 2)
//	{
//		printf("%d", (n >> i) & 1);
//	}
//}
//int main()
//{
//	int a = 0;
//	scanf("%d", &a);
//	Math(a);
//	return 0;
//}
//int Count(int i)
//{
//	int count = 0;
//	while (i != 0)
//	{
//		i = i & (i - 1);
//		count++;
//	}
//	return count;
//}
//int main()
//{
//	int a = 0;
//	scanf("%d", &a);
//	int b=Count(a);
//	printf("%d\n", b);
//	return 0;
//}
//void Change(int* p1, int*p2)
//{
//	*p1 = *p2^*p1;
//	*p2 = *p1^*p2;
//	*p1 = *p2^*p1;
//	printf("%d,%d\n", *p1, *p2);
//	
//}
//int main()
//{
//	int a = 0;
//	int b = 0;
//	scanf("%d%d", &a, &b);
//	Change(&a, &b);
//	return 0;
//}