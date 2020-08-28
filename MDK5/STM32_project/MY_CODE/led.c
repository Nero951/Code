#include "led.h"

void Led_Init(void)
{
   GPIO_InitTypeDef GPIO_InitStruct;  //����ṹ������
	 //ʹ��GPIOD��ʱ��
	 RCC_AHB1PeriphClockCmd(RCC_AHB1Periph_GPIOD,ENABLE);
	 
	GPIO_InitStruct.GPIO_Pin = GPIO_Pin_12;  //����GPIOD������PD12
	GPIO_InitStruct.GPIO_Mode = GPIO_Mode_OUT;  //ʹ�����ģʽ
	GPIO_InitStruct.GPIO_OType = GPIO_OType_PP;  //�������
	GPIO_InitStruct.GPIO_PuPd = GPIO_PuPd_UP;    //����������
	GPIO_InitStruct.GPIO_Speed = GPIO_Speed_50MHz;  //����ٶ� 50MHz
	
	//��ʼ��GPIOD
  GPIO_Init(GPIOD,&GPIO_InitStruct);
	
	GPIO_SetBits(GPIOD, GPIO_Pin_12);
}
