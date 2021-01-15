
#include <iostream>

#include <stack>          // std::stack
#include <utility>
#include <vector>
using namespace std;
int n;
class Stack {
   int top;
   int topTransaction;
public:
 vector<int> content;
 stack< pair<string, int> > instructions;

 Stack(int n) {
   top = -1; topTransaction=-1;
   content.resize(n + 1,0);
 }
   
   void push(int x, bool noTrace);
   void pop(int k, bool noTrace);
   int peek(int k);
   void begin();
   void rollback();
   void commit();
};

void Stack::push(int x, bool noTrace)
{
   if (top < n - 1) {
       content[++top] = x;
       if (!instructions.empty() && !noTrace) {
           pair<string, int> p("push", x);
           instructions.push(p);
       }
   }
}

void Stack::pop(int k, bool noTrace)
{
   if (top < 0) {
       return;
   }
   else {
       if (top > k - 1) {
           if (!instructions.empty() && !noTrace) {
               for (int i = top - k + 1; i <= top; ++i) {
                    pair<string, int> p("pop", content[i]);
                    instructions.push(p);
                }
               
           }
           
           top = top - k;
       }
       else {
           if (!instructions.empty() && !noTrace) {
               for (int i = 0; i <= top; ++i) {
                    pair<string, int> p("pop", content[i]);
                    instructions.push(p);
                }
           }
           top = -1;
       }
   }
}
int Stack::peek(int k)
{
   if (top < 0) {
       cout << 0 << endl;
       return 0;
   }
   else {
       if (k > top) {
           cout << 0 << endl;
           return content[0];
       }
       int x = content[top - k];
       cout << x << endl;
       return x;
   }
}
void Stack::begin()
{
   pair<string, int> p("begin", -1);
   instructions.push(p);
}

void Stack::rollback()
{
   if (instructions.empty()) {
       cout << "false" << endl;
       return;
   }

   while (!instructions.empty() && instructions.top().first != "begin") {
       pair<string, int> command = instructions.top();
       instructions.pop();

       if (command.first == "pop") {
           push(command.second, true);
       } else if (command.first == "push") {
           pop(1, true);
       }
   }
   instructions.pop();

   cout << "true" << endl;
}

void Stack::commit()
{
   if (instructions.empty()) {
       cout << "false" << endl;
       return;
   }
    stack <pair<string, int>> tempIns;
   while (!instructions.empty() && instructions.top().first != "begin") {
       pair<string, int> command = instructions.top();
       tempIns.push(command);
       instructions.pop();
   }
   instructions.pop();
    if (!instructions.empty()) {
        while (!tempIns.empty()) {
            pair<string, int> command = tempIns.top();
            tempIns.pop();
            instructions.push(command);
        }
    }
    
   
   cout << "true" << endl;

}



int main()
{
   cin >> n;
   Stack s(n+100);
   string operation;
   int num;
   for (int i=0; i<n; ++i) {
       cin >> operation;
       if (operation != "begin" && operation != "rollback" && operation != "commit") {
           cin >> num;
       }
       if (operation == "push") {
           s.push(num, false);
       } else if (operation == "pop") {
           s.pop(num, false);
       } else if (operation == "top") {
           s.peek(num);
       }
       else if (operation == "begin") {
           s.begin();
       }
       else if (operation == "rollback") {
           s.rollback();
       }
       else if (operation == "commit") {
           s.commit();
       }
   
   }
   

   return 0;
}
