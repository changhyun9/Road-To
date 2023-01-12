# 큰 수의 법칙
n, m, k = map(int, input().split()) # int형으로 공백을 기준으로 n,m,k를 입력받는 함수
data = list(map(int, input().split())) # int형으로 공백을 기준으로 입력받아 list로 저장하는 함수

data.sort() # 입력받은 data를 오름차순으로 정렬
first = data[n-1] # 입력받은 data 중 가장 큰 요소를 저장
second = data[n-2] # 입력받은 data 중 두번째로 큰 요소를 저장

count = int(m // (k+1)) * k # 가장 큰 요소가 나오는 횟수를 저장
count += m % (k+1) # 수열이 나누어 떨어지지 않을 경우 고려하는 상황

result = 0
result += (count) * first
result += (m - count) * second

print(result)
