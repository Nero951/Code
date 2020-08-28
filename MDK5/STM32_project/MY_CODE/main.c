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
		//从串口3接收数据
	  	
		  ch=USART_ReceiveData(USART3);
			while(USART_GetFlagStatus(USART3,USART_FLAG_TXE)==RESET);  
			USART_SendData(USART3,ch);
	  	
		
			//从串口1接收数据
		buffer[rx_count++] = ch;
		
		if(buffer[rx_count - 1] == ':') //接收字符结束
		{
			for(rx_i=0; rx_i<rx_count-1; rx_i++)
			{
				rx_buffer[rx_i] = buffer[rx_i];  //将有效数据存储到rx_buffer
			}
		
			rx_count = 0 ; //用于下次接受字符串时buffer从buffer[0]开始接受数据
			memset(buffer, 0, sizeof(buffer));
			rx_flag = 1;  //表示收到数据后标志位为1
		}
	
		//USART_SendData(USART1,rx_data);
	}

	//清除中断标志位
    USART_ClearITPendingBit(USART3,USART_IT_RXNE);


}




int main(void)
{
	
 	//NVIC分组
 	 NVIC_PriorityGroupConfig(NVIC_PriorityGroup_2);
   Led_Init();
	 Delay_Init();
	 Usart3_Init();	
	
	while(1)
	{ 
		
		if(rx_flag == 1)   //表示接受到数据
		{
			
			//printf("rx_buffer = %s\n",rx_buffer);
			
			if(strcmp(rx_buffer,"ZBC666") == 0)	//接受到1灯亮
			{
					GPIO_ResetBits(GPIOD, GPIO_Pin_12);
			}
			if(strcmp(rx_buffer,"ZBC777") == 0)	//接受到1灯灭
			{
				GPIO_SetBits(GPIOD, GPIO_Pin_12);
			}
			
			//清空数组
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
