class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y
        
    def __str__(self):
        return str(self.x) + "," + str(self.y)
    
    def __eq__(self, other):
        if(isinstance(other, Point)):
            return self.x == other.x and self.y == other.y
        return False

    def __hash__(self):
        return hash((self.x, self.y))

def solution(forth):
    # write your code in Python 3.6
    
    N = 1
    S = -1
    E = 1
    W = -1
    
    curX = 0
    curY = 0
    
    points = set()
    points.add(Point(0, 0))
    
    for ch in forth:
        if ch == 'N':
            curX += N
        elif ch == 'E':
            curY += E
        else:
            curY += W
        points.add(Point(curX, curY))
    
    #finalPt = Point(curX, curY)
    
    retPath = ""
    # for p in points:
    #     print(str(p))
        
    while not (curX == 0 and curY == 0):
        if  Point(curX - 1, curY) not in points:
            #print('came S')
            curX -= 1
            retPath += 'S'
        elif Point(curX, curY - 1) not in points:
            #print('came W')
            curY -= 1
            retPath += 'W'
        elif Point(curX, curY + 1) not in points:
            #print('came E')
            curY += 1
            retPath += 'E'
        elif Point(curX + 1, curY) not in points:
            #print('came E')
            curX += 1
            retPath += 'N'
            
    print(forth)
    return retPath


if __name__ == "__main__":
    print("Return path: " + solution('NEENWN'))