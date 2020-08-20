clc
clear all
close all
% 该程序单位统一为：m
step = 300;         %采样点数
% --平行平面腔参数--
lambda1 = 1064e-9;   %波长1064nm
k1 = 2*pi/lambda1;
L1 = 100*lambda1;     %腔长100λ
a1 = 25*lambda1;      %反射镜半径 25λ
F1 = a1^2/lambda1/L1;   %菲涅耳数 6.25
x1 = linspace(-a1,a1,step);

% --方形镜对称共焦腔参数--
lambda3 = 1064e-9;   %波长1064nm
k3 = 2*pi/lambda3;
L3 = 50*lambda3;     %腔长100λ
a3 = 25*lambda3;      %反射镜半径 25λ
F3 = a3^2/lambda3/L3;   %菲涅耳数 6.25
x3 = linspace(-a3,a3,step);
% 迭代一次
E0 = ones(1,step);  %均匀平面波
E0_1 = E0;

E0_3 = E0;
E1 = zeros(1,step);%先分配内存

E3 = zeros(1,step);%先分配内存
for j = 1:step
    E1(j) = pxpmq(L1,a1,k1,lambda1,x1(j),E0_1,step);    %E1代表平行平面腔
    
    E3(j) = dcgjq(L3,a3,k3,lambda3,x3(j),E0_3,step);    %E3代表方形镜对称共焦腔
end
phase_E1_1 = angle(E1);
I1_1 = E1.*conj(E1);
I1_1 = I1_1/max(max(I1_1));

phase_E3_1 = angle(E3);
I3_1 = E3.*conj(E3);
I3_1 = I3_1/max(max(I3_1));
% 迭代500次
N = 500;           %迭代次数
E0 = ones(1,step); %均匀平面波
E0_1 = E0;

E0_3 = E0;
E1 = zeros(1,step);%先分配内存
E3 = zeros(1,step);
for j = 1:N
    for jj = 1:step
        E1(jj) = pxpmq(L1,a1,k1,lambda1,x1(jj),E0_1,step);    %E1代表平行平面腔
        
        E3(jj) = dcgjq(L3,a3,k3,lambda3,x3(jj),E0_3,step);
    end
    E1 = E1/max(max(E1));
    E0_1 = E1;
    
    E3 = E3/max(max(E3));
    E0_3 = E3;
    j
end
phase_E1_N = angle(E1);   %求相位
I1_N = E1.*conj(E1);
I1_N = I1_N/max(max(I1_N));

phase_E3_N = angle(E3);   %求相位
I3_N = E3.*conj(E3);
I3_N = I3_N/max(max(I3_N));
% 画图
figure;%平行平面腔振幅
plot(x1,I1_1,'b',x1,I1_N,'r')
legend('迭代1次的振幅',['迭代',num2str(N),'的振幅']);
%set(gca,'fontname','times new roman','fontsize',14);    %设置图形对象属性
title('平行平面腔（临界腔）：振幅','fontname','华文中宋','fontsize',16);
xlabel('x/m','fontname','times new roman','fontsize',16);
ylabel('归一化强度','fontname','华文中宋','fontsize',16);

figure;%平行平面腔相位
plot(x1,phase_E1_1,'b',x1,phase_E1_N,'r')
legend('迭代1次的相位',['迭代',num2str(N),'的相位']);
%set(gca,'fontname','times new roman','fontsize',14);    %设置图形对象属性
title('平行平面腔（临界腔）：相位','fontname','华文中宋','fontsize',16);
xlabel('x/m','fontname','times new roman','fontsize',16);
ylabel('相对相位','fontname','华文中宋','fontsize',16);

figure;%方形镜对称共焦腔振幅
plot(x3,I3_1,'b',x3,I3_N,'r')
legend('迭代1次的振幅',['迭代',num2str(N),'的振幅']);
%set(gca,'fontname','times new roman','fontsize',14);    %设置图形对象属性
title('方形镜对称共焦腔（稳定腔）：振幅','fontname','华文中宋','fontsize',16);
xlabel('x/m','fontname','times new roman','fontsize',16);
ylabel('归一化强度','fontname','华文中宋','fontsize',16);

figure;%方形镜对称共焦腔相位
plot(x3,phase_E3_1,'b',x3,phase_E3_N,'r')
legend('迭代1次的相位',['迭代',num2str(N),'的相位']);
%set(gca,'fontname','times new roman','fontsize',14);    %设置图形对象属性
title('方形镜对称共焦腔（稳定腔）：相位','fontname','华文中宋','fontsize',16);
xlabel('x/m','fontname','times new roman','fontsize',16);
ylabel('相对相位','fontname','华文中宋','fontsize',16);

% 平行平面腔（临界腔）
function result = pxpmq(L,a,k,lambda,x,E0_1,step)
x_=linspace(-a,a,step);
step_length=2*a/(step-1);
result = sqrt(1i/lambda/L*exp(-1i*k*L))*sum(exp(-1i*k/2/L*(x-x_).^2).*E0_1)*step_length;
end

% 方形镜对称共焦腔（稳定腔）
function result = dcgjq(L,a,k,lambda,x,E0_3,step)
x_=linspace(-a,a,step);
result = 1i/lambda/L*exp(1i*k*L)*sum(E0_3.*exp(1i*k*x*x_/L));
end