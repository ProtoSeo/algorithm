# [Gold V] 규칙적인 보스돌이 - 29792 

[문제 링크](https://www.acmicpc.net/problem/29792) 

### 성능 요약

메모리: 14424 KB, 시간: 152 ms

### 분류

브루트포스 알고리즘, 다이나믹 프로그래밍, 배낭 문제

### 제출 일자

2024년 3월 13일 09:51:24

### 문제 설명

<p>카오는 오랫동안 메이플스토리를 플레이하며 $N$개의 캐릭터를 육성하였다.</p>

<p>지속적인 스펙업을 위해 꾸준하게 메소를 벌어야 할 필요성을 느낀 카오는, 지금까지 키워온 캐릭터들을 활용하여 메소를 벌기로 하였다. 여러 캐릭터로 보스를 효율적으로 잡기 위해, 하루에 한 캐릭터 당 최대 $15$분씩, 최대 $M$개의 캐릭터만 보스를 잡기로 하였다.</p>

<p>캐릭터가 보스에게 데미지를 넣으면 보스의 체력이 데미지만큼 감소하며, 보스의 체력이 $0$ 이하가 되면 보스를 잡게 된다. 데미지의 계산은 매초 이루어지기 때문에, $1$초 미만의 시간 동안 적용된 데미지는 보스에게 적용되지 않는다.</p>

<p>캐릭터마다 주어진 $15$분 동안은 매초 일정한 데미지를 넣을 수 있으며, 보스를 잡은 후 다른 보스를 잡으러 떠나는 시간은 계산하지 않는다. 캐릭터마다 각 보스는 $1$회씩만 처치할 수 있으며, 다른 캐릭터가 잡은 보스라도, 현재 캐릭터가 잡지 않은 보스라면 잡을 수 있다. 보스를 잡던 도중 캐릭터를 변경하는 것은 불가능하며, 캐릭터가 상대하는 보스의 체력은 공유되지 않아, 오롯이 한 캐릭터의 힘으로 보스를 상대해야 한다.</p>

<p>보스 몬스터의 체력, 보상 메소 정보와 캐릭터의 데미지 정보가 주어질 때, 카오가 계획에 맞추어 하루에 보스를 잡아 얻을 수 있는 최대 메소를 구해보자.</p>

### 입력 

 <p>첫 줄에는 보유한 캐릭터의 개수 $N$, 하루에 사용할 캐릭터의 개수 $M$, 보스의 가짓수 $K$가 공백으로 구분되어 주어진다. $(1 \le M \le N \le 49;$ $1 \le K \le 13)$</p>

<p>그다음 $N$줄에 걸쳐서 캐릭터가 $1$초에 가하는 데미지 $D$가 주어진다. $(1 \le D \le 10^{11})$</p>

<p>그다음 $K$줄에 걸쳐서 보스의 체력 $P$와 보스를 처치했을 때 드랍하는 메소 $Q$가 공백으로 구분되어 주어진다. $(1 \le P \le 2.66 \times 10^{11};$ $1 \le Q \le 1\,596\,506)$</p>

<p>입력으로 들어오는 모든 수는 정수임이 보장된다.</p>

### 출력 

 <p>카오가 계획에 맞추어 보스를 잡았을 때, 하루에 보스를 잡아 얻을 수 있는 최대 메소를 출력한다.</p>

