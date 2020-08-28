#include "led.h"

void Led_Init(void)
{
   GPIO_InitTypeDef GPIO_InitStruct;  //定义结构体名称
	 //使能GPIOD的时钟
	 RCC_AHB1PeriphClockCmd(RCC_AHB1Periph_GPIOD,ENABLE);
	 
	GPIO_InitStruct.GPIO_Pin = GPIO_Pin_12;  //控制GPIOD的引脚PD12
	GPIO_InitStruct.GPIO_Mode = GPIO_Mode_OUT;  //使用输出模式
	GPIO_InitStruct.GPIO_OType = GPIO_OType_PP;  //推挽输出
	GPIO_InitStruct.GPIO_PuPd = GPIO_PuPd_UP;    //带上拉电阻
	GPIO_InitStruct.GPIO_Speed = GPIO_Speed_50MHz;  //输出速度 50MHz
	
	//初始化GPIOD
  GPIO_Init(GPIOD,&GPIO_InitStruct);
	
	GPIO_SetBits(GPIOD, GPIO_Pin_12);
}
