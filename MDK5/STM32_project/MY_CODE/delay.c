#include "delay.h"

u32 my_nus = 21;
u32 my_nms = 21000;

void Delay_Init(void)
{
	//HCLK 时钟8分频 168MHz/8 = 21MHz 
  SysTick_CLKSourceConfig(SysTick_CLKSource_HCLK_Div8);

}

//nus取值范围：0~798951 ，24位时钟

void delay_us(int nus)
{
  u32 temp = 0; //u32 = unsigned int
  // 重装值寄存器
	SysTick->LOAD = my_nus*nus - 1; //得到要计数的值
	
	SysTick->VAL  = 0;  //计数起始值
	//启动定时器，开始计数
	SysTick->CTRL |=(1<<0);
  //判断计数是否结束
  do{
	
	  temp = SysTick->CTRL;
		
	}while((temp & (1<<0)) &&  !(temp & (1<<16)));	
	//关闭定时器
	SysTick->CTRL &=~(1<<0);
	
}

//nms取值范围：0~798

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

