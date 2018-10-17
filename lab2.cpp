/*
Jessica Hilario
CECS 328
Lab 2
*/
#include <iostream>
#include <cmath>
#include <chrono>
using namespace std;
using namespace std::chrono;

int question1();
void question2();
double squareRoot(int);
int ceiling(double);
void runningTime(auto, auto, int);
int binarySearch(int a[], int);

int main() {
	int q1 = question1();
	cout << "The squareroot of N is  " << q1 << endl;
	cout << endl;
	question2();
}

int question1() {
	auto start = high_resolution_clock::now(); //Start the running time of the first question
	int N;
	cout << "Question 1: We will be implementing the ceiling function on a square root function." << endl;
	cout << "Enter an integer: " << endl;
	cin >> N;
	int ans = ceiling(squareRoot(N));
	auto stop = high_resolution_clock::now();
	runningTime(start,stop, N);
	return ans;
}

void question2() {
	auto start = high_resolution_clock::now();
	int k, user_input = 1, n;
	cout << "Question 2: Find the position of k that splits the 0s and 1s." << endl;
	cout << "Write 0s first for a number of times then switch it to 1s. Write any other number that's not binary" << endl;
	cout << "How big do you want the array? ";
	cin >> n;
	int a[n];
	cout << "Add binary digits." << endl;
	int i = 0;
	while(i < n and (user_input == 1 or user_input == 0)) {
		cin >> user_input;
		a[i] = user_input;
		i++;
	}
	cout << "The array starts to switch from 0 to 1 by the " << binarySearch(a, n) << " index." << endl;
	auto stop = high_resolution_clock::now();
	runningTime(start,stop,n); //Calculate the running time
}

double squareRoot(int n) { //Using the babylonian way
	double error = 0.00001;
	double ans = double(n);
	
	while ((ans-n/ans)>error) {
		ans = (ans + n/ans)/2;
	}
	return ans;
}

int ceiling(double c) { //Checks to see if it's a whole number or not to round up
	int ans = int(c);
	int k;
	if (double(ans) == c) {
		return ans;
	}
	return ans + 1;
}

int binarySearch(int a[], int n) { //Looks up where k is
	int number_to_find = 1;
	int mn = 0;
	int mx = n;
	int i, k;
	while(mn <= mx) {
		if (a[mn] == 0 and a[mn+1] == 1) {
			k = mn + 1;
			return k;
			break;
		} else {
			mn++;
		}
	}
	return -1;
}

void runningTime(auto start, auto stop, int n) { //Calculates the running time
	auto duration = duration_cast<nanoseconds>(stop-start);
	long dc = duration.count();
	long running_time = dc/log2(n);
	cout << "<Running time... " << abs(running_time) << "ns>" << endl << endl;
}