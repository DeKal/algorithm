#include <iostream>
#include <algorithm>
#include <vector>
#include <utility>
#include <stdlib.h>
using namespace std;

int n;
vector<pair<int,int>> houses;

bool sortByDistance (pair<int,int> pair1,pair<int,int> pair2) {
  if (pair1.second == pair2.second) {
    return pair1.first < pair2.first;
  }
  return (pair1.second < pair2.second);
}

int searchNearestHouse(int location) {
  int left = 0; int right = n-1;

  while (left < right - 1) {
    
    int middle = (left + right) /2;
    if (houses[middle].second < location) {
      left = middle;
    } else if (houses[middle].second > location) {
      right = middle;
    } else {
      return houses[middle].first;
    }
  }

  if (abs(houses[left].second - location) <  abs(houses[right].second - location)) {
    return houses[left].first;
  }

  if (abs(houses[left].second - location) > abs(houses[right].second - location)) {
    return houses[right].first;
  }

  if (houses[left].first < houses[right].first)
    return houses[left].first;

  return houses[right].first;
}

void trimIdenticalOnSortedArray() {
  for (int i=0; i<n-1; ++i) {
    if (houses[i].second == houses[i+1].second) {
      houses[i+1].first = houses[i].first;
    }
  }
}

int main() {
  cin >> n;


  for (int i=0; i<n; ++i) {
    int label;
    int distance;
    cin >> label >> distance;
    pair<int, int> myPair(label, distance);
    houses.push_back(myPair);
  }

  sort(houses.begin(), houses.end(), sortByDistance);

  trimIdenticalOnSortedArray();

  int location;
  while (cin >> location)
  {
    cout << searchNearestHouse(location) << endl;
  }

}
