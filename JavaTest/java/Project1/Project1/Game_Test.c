#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include<time.h>
#include<stdlib.h>
void menu()
{
	printf("**************************\n");
	printf("****1.play      0.exit****\n");
	printf("**************************\n");
}
void game()
{
	//1.��������һ�������  2.������
	int ret = rand()%100+1;
	//printf("%d\n", ret);
	int guess = 0;
	while (1) 
	{
		printf("�������:");
		scanf("%d", &guess);
		if (guess > ret)
		{
			printf("�´���\n");
		}
		else if (guess == ret)
		{
			printf("�¶���\n");
			break;
		}
		else
		{
			printf("��С��\n");
		}
	}
}
int main()
{
	srand((unsigned int)time(NULL));
	int input = 0;
	do {
		menu();
		
		printf("��ѡ��");
	    scanf("%d", &input);
		switch (input)
		{
		case 1:
			printf("��ʼ��Ϸ\n");
			game();
			break;
		case 0:
			printf("�˳���Ϸ\n");
			break;
		default:
			printf("ѡ�����\n");
			break;
		}
	} while (input);
	return 0;
}