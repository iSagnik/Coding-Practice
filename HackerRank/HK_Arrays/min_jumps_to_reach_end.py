# Python3 program to find Minimum 
# number of jumps to reach end 

# Returns minimum number of jumps 
# to reach arr[n-1] from arr[0] 
def minJumps1(arr, n): 
	jumps = [0 for i in range(n)] 

	if (n == 0) or (arr[0] == 0): 
		return float('inf') 

	jumps[0] = 0

	# Find the minimum number of 
	# jumps to reach arr[i] from 
	# arr[0] and assign this 
	# value to jumps[i] 
	for i in range(1, n): 
		jumps[i] = float('inf') 
		for j in range(i): 
			if (i <= j + arr[j]) and (jumps[j] != float('inf')): 
				jumps[i] = min(jumps[i], jumps[j] + 1) 
				break
	return jumps[n-1] 

# Python3 progrma to find Minimum 
# number of jumps to reach end 

# Returns Minimum number of 
# jumps to reach end 
def minJumps2(arr, n): 
	
	# jumps[0] will hold the result 
	jumps = [0 for i in range(n)] 

	# Minimum number of jumps needed 
	# to reach last element from 
	# last elements itself is always 0 
	# jumps[n-1] is also initialized to 0 

	# Start from the second element, 
	# move from right to left and 
	# construct the jumps[] array where 
	# jumps[i] represents minimum number 
	# of jumps needed to reach arr[m-1] 
	# form arr[i] 
	for i in range(n-2, -1, -1): 
		
		# If arr[i] is 0 then arr[n-1] 
		# can't be reached from here 
		if (arr[i] == 0): 
			jumps[i] = float('inf') 

		# If we can directly reach to 
		# the end point from here then 
		# jumps[i] is 1 
		elif (arr[i] >= n - i - 1): 
			jumps[i] = 1

		# Otherwise, to find out the 
		# minimum number of jumps 
		# needed to reach arr[n-1], 
		# check all the points 
		# reachable from here and 
		# jumps[] value for those points 
		else: 
			# initialize min value 
			min = float('inf') 

			# following loop checks with 
			# all reachavle points and 
			# takes the minimum 
			for j in range(i + 1, n): 
				if (j <= arr[i] + i): 
					if (min > jumps[j]): 
						min = jumps[j] 
						
			# Handle overflow 
			if (min != float('inf')): 
				jumps[i] = min + 1
			else: 
				# or INT_MAX 
				jumps[i] = min

	return jumps[0] 

# Driver Program to test above function 
arr = [1, 3, 6, 1, 0, 9] 
size = len(arr) 
print('#1. Minimum number of jumps to reach', 
	'end is', minJumps1(arr, size)) 

print("\n\n#2. Minimum number of jumps to reach", 
	'end is', minJumps1(arr, size)) 