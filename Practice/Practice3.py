n, m = map(int, input().split()) # n,m을 입력
answer, minValue  = 0,0 # 각 각 최종 답안을 반환하기 위한 변수, 행에서의 최소값을 저장하기 위한 변수

for _ in range(n): # 입력받은 n만큼 반복
    data = list(map(int, input().split())) # data에 행의 수를 입력받음
    minValue = min(data) # 행에서의 최소값을 저장
    answer = max(answer, minValue) # 반복 될때마다 행에서의 최소값끼리 더 큰값을 저장

print (answer)

