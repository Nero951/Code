#include "usart.h"
#include "stdio.h"


#pragma import(__use_no_semihosting)             
//��׼����Ҫ��֧�ֺ���                 
struct __FILE 
{ 
	int handle; 
}; 

FILE __stdout;       
//����_sys_exit()�Ա���ʹ�ð�����ģʽ    
int _sys_exit(int x) 
{ 
	x = x; 
} 

//�ض���fputc����   printf ��һ����
int fputc(int ch, FILE *f)
{ 	
	USART_SendData(USART3,ch);
	while(USART_GetFlagStatus(USART3,USART_FLAG_TXE)==RESET);      
	return ch;
}


void Usart3_Init(void)
{
	GPIO_InitTypeDef  			GPIO_InitStruct;
	USART_InitTypeDef 			USART_InitStruct;
	NVIC_InitTypeDef  			NVIC_InitStruct;
	//ʹ�� USART1 ʱ��
	RCC_APB1PeriphClockCmd(RCC_APB1Periph_USART3,ENABLE);	
	//ʹ�õ��Ǵ��� 1������ 1 ��Ӧ��оƬ���� PA9,PA10 ��Ҫʹ��PA���ʱ��
	RCC_AHB1PeriphClockCmd(RCC_AHB1Periph_GPIOB,ENABLE); 

	//�������Ÿ�����ӳ�䣺���� GPIO_PinAFConfig ������
	GPIO_PinAFConfig(GPIOB,GPIO_PinSource10,GPIO_AF_USART3); 
	GPIO_PinAFConfig(GPIOB,GPIO_PinSource11,GPIO_AF_USART3);
	
	
	GPIO_InitStruct.GPIO_Pin	= GPIO_Pin_10|GPIO_Pin_11;	//����9
	GPIO_InitStruct.GPIO_Mode	= GPIO_Mode_AF;				//����
	GPIO_InitStruct.GPIO_OType	= GPIO_OType_PP;			//�������
	GPIO_InitStruct.GPIO_Speed	= GPIO_Speed_50MHz;			//50MHZ
	GPIO_InitStruct.GPIO_PuPd	= GPIO_PuPd_UP;				//����
	//��ʼ��IO��Ϊ���ù������
	GPIO_Init(GPIOB, &GPIO_InitStruct);
	//GPIO ��ʼ�����ã�Ҫ����ģʽΪ���ù��ܡ�
	
	
	USART_InitStruct.USART_BaudRate 			= 9600;				//һ������Ϊ 115200;
	USART_InitStruct.USART_WordLength 			= USART_WordLength_8b;	//�ֳ�Ϊ 8 λ���ݸ�ʽ
	USART_InitStruct.USART_StopBits 			= USART_StopBits_1;		//һ��ֹͣλ
	USART_InitStruct.USART_Parity 				= USART_Parity_No;		//����żУ��λ
	USART_InitStruct.USART_HardwareFlowControl  = USART_HardwareFlowControl_None;//��Ӳ��������
	USART_InitStruct.USART_Mode 				= USART_Mode_Rx | USART_Mode_Tx;//�շ�ģʽ
	//���ڲ�����ʼ�������ò����ʣ��ֳ�����żУ��Ȳ�����
	USART_Init(USART3, &USART_InitStruct); 

	NVIC_InitStruct.NVIC_IRQChannel						= USART3_IRQn;  //����1ͨ��
	NVIC_InitStruct.NVIC_IRQChannelPreemptionPriority	= 2; 			//��ռ���ȼ�
	NVIC_InitStruct.NVIC_IRQChannelSubPriority			= 2; 			//��Ӧ���ȼ�
	NVIC_InitStruct.NVIC_IRQChannelCmd					= ENABLE;		//ͨ��ʹ��
	//�����жϲ��ҳ�ʼ�� NVIC��ʹ���жϣ������Ҫ���������жϲ���Ҫ������裩��
    NVIC_Init(&NVIC_InitStruct);		
	
	//��֮CPU�жϵķ�ʽ
	USART_ITConfig(USART3,USART_IT_RXNE,ENABLE);
	//ʹ�ܴ��ڡ�
	USART_Cmd(USART3, ENABLE); 

}

