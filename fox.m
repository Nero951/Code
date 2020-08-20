clc
clear all
close all
% �ó���λͳһΪ��m
step = 300;         %��������
% --ƽ��ƽ��ǻ����--
lambda1 = 1064e-9;   %����1064nm
k1 = 2*pi/lambda1;
L1 = 100*lambda1;     %ǻ��100��
a1 = 25*lambda1;      %���侵�뾶 25��
F1 = a1^2/lambda1/L1;   %�������� 6.25
x1 = linspace(-a1,a1,step);

% --���ξ��Գƹ���ǻ����--
lambda3 = 1064e-9;   %����1064nm
k3 = 2*pi/lambda3;
L3 = 50*lambda3;     %ǻ��100��
a3 = 25*lambda3;      %���侵�뾶 25��
F3 = a3^2/lambda3/L3;   %�������� 6.25
x3 = linspace(-a3,a3,step);
% ����һ��
E0 = ones(1,step);  %����ƽ�沨
E0_1 = E0;

E0_3 = E0;
E1 = zeros(1,step);%�ȷ����ڴ�

E3 = zeros(1,step);%�ȷ����ڴ�
for j = 1:step
    E1(j) = pxpmq(L1,a1,k1,lambda1,x1(j),E0_1,step);    %E1����ƽ��ƽ��ǻ
    
    E3(j) = dcgjq(L3,a3,k3,lambda3,x3(j),E0_3,step);    %E3�����ξ��Գƹ���ǻ
end
phase_E1_1 = angle(E1);
I1_1 = E1.*conj(E1);
I1_1 = I1_1/max(max(I1_1));

phase_E3_1 = angle(E3);
I3_1 = E3.*conj(E3);
I3_1 = I3_1/max(max(I3_1));
% ����500��
N = 500;           %��������
E0 = ones(1,step); %����ƽ�沨
E0_1 = E0;

E0_3 = E0;
E1 = zeros(1,step);%�ȷ����ڴ�
E3 = zeros(1,step);
for j = 1:N
    for jj = 1:step
        E1(jj) = pxpmq(L1,a1,k1,lambda1,x1(jj),E0_1,step);    %E1����ƽ��ƽ��ǻ
        
        E3(jj) = dcgjq(L3,a3,k3,lambda3,x3(jj),E0_3,step);
    end
    E1 = E1/max(max(E1));
    E0_1 = E1;
    
    E3 = E3/max(max(E3));
    E0_3 = E3;
    j
end
phase_E1_N = angle(E1);   %����λ
I1_N = E1.*conj(E1);
I1_N = I1_N/max(max(I1_N));

phase_E3_N = angle(E3);   %����λ
I3_N = E3.*conj(E3);
I3_N = I3_N/max(max(I3_N));
% ��ͼ
figure;%ƽ��ƽ��ǻ���
plot(x1,I1_1,'b',x1,I1_N,'r')
legend('����1�ε����',['����',num2str(N),'�����']);
%set(gca,'fontname','times new roman','fontsize',14);    %����ͼ�ζ�������
title('ƽ��ƽ��ǻ���ٽ�ǻ�������','fontname','��������','fontsize',16);
xlabel('x/m','fontname','times new roman','fontsize',16);
ylabel('��һ��ǿ��','fontname','��������','fontsize',16);

figure;%ƽ��ƽ��ǻ��λ
plot(x1,phase_E1_1,'b',x1,phase_E1_N,'r')
legend('����1�ε���λ',['����',num2str(N),'����λ']);
%set(gca,'fontname','times new roman','fontsize',14);    %����ͼ�ζ�������
title('ƽ��ƽ��ǻ���ٽ�ǻ������λ','fontname','��������','fontsize',16);
xlabel('x/m','fontname','times new roman','fontsize',16);
ylabel('�����λ','fontname','��������','fontsize',16);

figure;%���ξ��Գƹ���ǻ���
plot(x3,I3_1,'b',x3,I3_N,'r')
legend('����1�ε����',['����',num2str(N),'�����']);
%set(gca,'fontname','times new roman','fontsize',14);    %����ͼ�ζ�������
title('���ξ��Գƹ���ǻ���ȶ�ǻ�������','fontname','��������','fontsize',16);
xlabel('x/m','fontname','times new roman','fontsize',16);
ylabel('��һ��ǿ��','fontname','��������','fontsize',16);

figure;%���ξ��Գƹ���ǻ��λ
plot(x3,phase_E3_1,'b',x3,phase_E3_N,'r')
legend('����1�ε���λ',['����',num2str(N),'����λ']);
%set(gca,'fontname','times new roman','fontsize',14);    %����ͼ�ζ�������
title('���ξ��Գƹ���ǻ���ȶ�ǻ������λ','fontname','��������','fontsize',16);
xlabel('x/m','fontname','times new roman','fontsize',16);
ylabel('�����λ','fontname','��������','fontsize',16);

% ƽ��ƽ��ǻ���ٽ�ǻ��
function result = pxpmq(L,a,k,lambda,x,E0_1,step)
x_=linspace(-a,a,step);
step_length=2*a/(step-1);
result = sqrt(1i/lambda/L*exp(-1i*k*L))*sum(exp(-1i*k/2/L*(x-x_).^2).*E0_1)*step_length;
end

% ���ξ��Գƹ���ǻ���ȶ�ǻ��
function result = dcgjq(L,a,k,lambda,x,E0_3,step)
x_=linspace(-a,a,step);
result = 1i/lambda/L*exp(1i*k*L)*sum(E0_3.*exp(1i*k*x*x_/L));
end