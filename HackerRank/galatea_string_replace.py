def solution(S):
    # write your code in Python 3.6
    while( True ):
        
        if "AA" in S:
            S = S.replace("AA", "", 1)
        elif "BB" in S:
            S = S.replace("BB", "", 1)
        elif "CC" in S:
            S = S.replace("CC", "", 1)
        else:
            return S

print(solution("ABCBBCBA"))