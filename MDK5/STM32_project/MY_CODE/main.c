#include "stm32f4xx.h"
#include "stdio.h"
#include "led.h"
#include "delay.h"
#include "usart.h"
#include "string.h"


int rx_i, rx_count = 0, rx_flag = 0;
char buffer[64] = {0};
char rx_buffer[64] = {0};


void USART3_IRQHandler(void)
{

	char ch;
	if(USART_GetITStatus(USART3,USART_IT_RXNE)   == SET)
	{
		//�Ӵ���3��������
	  	
		  ch=USART_ReceiveData(USART3);
			while(USART_GetFlagStatus(USART3,USART_FLAG_TXE)==RESET);  
			USART_SendData(USART3,ch);
	  	
		
			//�Ӵ���1��������
		buffer[rx_count++] = ch;
		
		if(buffer[rx_count - 1] == ':') //�����ַ�����
		{
			for(rx_i=0; rx_i<rx_count-1; rx_i++)
			{
				rx_buffer[rx_i] = buffer[rx_i];  //����Ч���ݴ洢��rx_buffer
			}
		
			rx_count = 0 ; //�����´ν����ַ���ʱbuffer��buffer[0]��ʼ��������
			memset(buffer, 0, sizeof(buffer));
			rx_flag = 1;  //��ʾ�յ����ݺ��־λΪ1
		}
	
		//USART_SendData(USART1,rx_data);
	}

	//����жϱ�־λ
    USART_ClearITPendingBit(USART3,USART_IT_RXNE);


}




int main(void)
{
	
 	//NVIC����
 	 NVIC_PriorityGroupConfig(NVIC_PriorityGroup_2);
   Led_Init();
	 Delay_Init();
	 Usart3_Init();	
	
	while(1)
	{ 
		
		if(rx_flag == 1)   //��ʾ���ܵ�����
		{
			
			//printf("rx_buffer = %s\n",rx_buffer);
			
			if(strcmp(rx_buffer,"ZBC666") == 0)	//���ܵ�1����
			{
					GPIO_ResetBits(GPIOD, GPIO_Pin_12);
			}
			if(strcmp(rx_buffer,"ZBC777") == 0)	//���ܵ�1����
			{
				GPIO_SetBits(GPIOD, GPIO_Pin_12);
			}
			
			//�������
			memset(rx_buffer, 0, sizeof(rx_buffer));
			
			rx_flag = 0;
		}
/*		
		GPIO_ResetBits(GPIOD, GPIO_Pin_12);
		
		delay_s(1);
		
		GPIO_SetBits(GPIOD, GPIO_Pin_12);
		
		delay_s(1);
*/	 	
	}
	
	
}
