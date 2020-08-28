#include "delay.h"

u32 my_nus = 21;
u32 my_nms = 21000;

void Delay_Init(void)
{
	//HCLK ʱ��8��Ƶ 168MHz/8 = 21MHz 
  SysTick_CLKSourceConfig(SysTick_CLKSource_HCLK_Div8);

}

//nusȡֵ��Χ��0~798951 ��24λʱ��

void delay_us(int nus)
{
  u32 temp = 0; //u32 = unsigned int
  // ��װֵ�Ĵ���
	SysTick->LOAD = my_nus*nus - 1; //�õ�Ҫ������ֵ
	
	SysTick->VAL  = 0;  //������ʼֵ
	//������ʱ������ʼ����
	SysTick->CTRL |=(1<<0);
  //�жϼ����Ƿ����
  do{
	
	  temp = SysTick->CTRL;
		
	}while((temp & (1<<0)) &&  !(temp & (1<<16)));	
	//�رն�ʱ��
	SysTick->CTRL &=~(1<<0);
	
}

//nmsȡֵ��Χ��0~798

void delay_ms(int nms)
{
  u32 temp = 0; //u32 = unsigned int
  
	SysTick->LOAD = my_nms*nms - 1;
	SysTick->VAL  = 0;
	
	SysTick->CTRL |=(1<<0);
  
  do{
	
	  temp = SysTick->CTRL;
		
	}while((temp & (1<<0)) &&  !(temp & (1<<16)));	
	
	SysTick->CTRL &=~(1<<0);
	
}

void delay_s(int ns)
{
  int i;
	for(i = 0;i<ns;i++)
	{
	 delay_ms(500);
	 delay_ms(500);
	
	}

}

