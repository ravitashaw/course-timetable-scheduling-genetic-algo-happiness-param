/*
 * File:   main.cpp
 * Author: ravypc
 *
 * Created on May 11, 2013, 3:32 PM
 */

#include<stdio.h>
#include<dos.h>
#include <conio.h>
#include<math.h>
#include<stdlib.h>
#include<alloc.h>
#include<time.h>
#include<iostream.h>
#define max_population_size 5
#define max_num_of_lecturers 15
#define max_num_of_classes 50
#define max_num_of_prac 30
#define max_num_of_tut 30
#define max_room_num 3
#define max_lab_num 9
#define days_in_week  6
#define hours_in_day  8
#define class_num int

const int  cost_of_related_class_clash = 1;
const int cost_of_room_too_small = 100;
const int cost_of_lecturer_double_booked = 1;
const int cost_of_unavailable_lecturer =  20;
/*
 * Type declarations.
 */
typedef long cost_type;
typedef int coordinate_type;
typedef coordinate_type  room_location_type[2];
typedef char  class_name_type[6];
typedef int associated_class_code_type;
typedef char lecturer_name_type[30];
typedef int lecturer_code_type;
typedef int reference_num_of_lecturer_type;
typedef int class_size_type;
typedef int availability_time_table [days_in_week] [hours_in_day];


typedef struct lecturer {
lecturer_name_type name_of_lecturer;
lecturer_code_type code_of_lecturer;
room_location_type home_office_location_of_lecturer;
availability_time_table availability_time_table_of_lecturer;
};

struct collection_of_lecturers {
struct lecturer  lecturers [max_num_of_lecturers];
int num_of_lecturers;
} lecturer_constraints;


typedef struct classr{
class_name_type name_of_class;
reference_num_of_lecturer_type reference_num_of_lecturer;
int batch;
class_size_type size_of_class;
associated_class_code_type associated_class_code;
room_location_type home_office_location_of_class;
};


struct collection_of_classes {
struct classr classes [max_num_of_classes];
int num_of_classes;
int num_of_class_associations;
} class_constraints;


typedef struct prac{
class_name_type name_of_prac;
int reference_lab_num;
int batch;
int prac_size;
};


struct collection_of_pracs{
struct prac pracs[max_num_of_prac];
int num_of_pracs;
} prac_constraints;

typedef struct tut{
class_name_type name_of_tut;
int batch;
};
struct collection_of_tut{
struct tut tuts[max_num_of_tut];
int num_of_tuts;
} tut_constraints;




typedef char  room_name_type[10];
typedef int   room_capacity_type;


typedef struct room{
room_name_type name_of_room ;
room_capacity_type capacity_of_room;
room_location_type location_of_room;
availability_time_table availability_time_table_of_room;
};

struct collection_of_labs{
struct room rooms[max_lab_num];
int num_of_labs;
}lab_constraints;       
        
struct collection_of_rooms {
struct room rooms [max_room_num];
int num_of_rooms;
} room_constraints;



typedef struct time_table {
struct time_table  *next;
class_num bookings [max_room_num] [days_in_week] [hours_in_day];
class_num lbookings [max_lab_num] [days_in_week] [hours_in_day];
class_num tbookings [max_room_num] [days_in_week] [hours_in_day];
cost_type cost;
cost_type rcc_error_count;
cost_type  rts_error_count;
cost_type ldb_error_count;
cost_type lua_error_count;
cost_type lab_error_count;
cost_type tut_error_count;
};
typedef int population_size_type;
typedef char colony_name_type[80];


struct colony {
colony_name_type name_of_colony;
struct time_table  *first_time_table;
struct time_table *last_time_table;
population_size_type population_size;
cost_type average_cost;
cost_type rcc_error_count;
cost_type  rts_error_count;
cost_type ldb_error_count;
cost_type lua_error_count;
} solution_colony;
typedef char file_name_type[12];
/*
 *  Prototypes
 */
int main(void);
int initialise_constraints(file_name_type constraint_file_name);
int repair_strategy(struct time_table  *curr_ptr);
int repair_strategy_0(struct time_table  *curr_ptr);
int calculate_cost(struct time_table  *curr_ptr);
int initialise_colony(void);
int find_average_cost(void);
int kill_costly_colony_members(void);
int breed_colony(void);
int output_colony(file_name_type out_file_name);
int mutate(struct time_table  *curr_ptr);
int pop_size(void);
int population_size;
long related_classes(struct time_table  *curr_ptr);
long room_too_small(struct time_table * curr_ptr);
long lecturer_unavailable(struct time_table * curr_ptr);
long lab_nalloc(struct time_table * curr_ptr);
long tut_nalloc(struct time_table * curr_ptr);
int fget_string(FILE *in, char wordy[80]);
int value_of(char wordy[80]);
int fget_line_value(FILE *in);
int fgetc_value(FILE *in);
void fputn(int number, FILE *fp);
int output_happy(file_name_type out_file_name);
int output_lab(file_name_type out_lab_name);
int output_tut(file_name_type out_lab_name);
//int output_debugg(struct time_table  *curr_ptr);
///debug
//void output_debug(struct time_table  *curr_ptr);

/* to calculate the happiness from the time table 
*/
int happiness(struct time_table  *curr_ptr)
{
    int flag=0;
    int hp=0;
    int hour=0;
for (int curr_day=0; curr_day < days_in_week; curr_day++)
{
    for (hour=(hours_in_day-1);hour>=0; hour--)
{   flag=0;
    for(int curr_room=0;curr_room < room_constraints.num_of_rooms; curr_room ++)
      if (curr_ptr -> bookings[curr_room][curr_day][hour]!=0)
       {flag=1; 
       break;
       }
       if(flag)
       {cout<<" "<<((hours_in_day-1)-hour)<<" on "<<curr_day;
       
       break;
       }
       
} 
hp=hp+((hours_in_day-1)-hour); 
}   
return hp;
}


/* to calculate the happiness from the time table   new function <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
*/
int happiness1(struct time_table  *curr_ptr)
{
    int flag=0;
    int penalty=3;
    int hp=0;
    int hour=0;
for (int curr_day=0; curr_day < days_in_week; curr_day++)
{
    for (hour=(hours_in_day-1);hour>=0; hour--)
{   flag=0;
    for(int curr_room=0;curr_room < room_constraints.num_of_rooms; curr_room ++)
      { if (curr_ptr -> bookings[curr_room][curr_day][hour]!=0)
        {flag=1; 
        break;
        }
        
      } 
       if(flag)
       {cout<<" "<<((hours_in_day-1)-hour)<<" on "<<curr_day;
       
       break;
       }
       
} 
hp=hp+((hours_in_day-1)-hour); 

}   
for (int curr_day=0; curr_day < days_in_week; curr_day++)
for (hour=(hours_in_day-1);hour>=0; hour--)
for(int curr_room=0;curr_room < room_constraints.num_of_rooms; curr_room ++)
{if(hour==0||hour==5)
if(curr_ptr -> bookings[curr_room][curr_day][hour]!=0)
penalty++;

}

hp=hp-penalty;
return hp;
}

//calculate the random values
int random(int a)
{
    int k= rand()%a;
    return k;
}
/*
 *  Global variables
 */
int mutation_rate = 16;
int num_of_trials = 0;
cost_type   maximum_allowed_cost = 0;
cost_type   maximum_lab_cost = 1;

/*
 *  main -
 *
 *  evolves timetables in the direction of minimum number of breaches
 *  of all constraints included.
 *
 *  Terminates when one perfect timetable has been created.
 *
 *
 */

int main(void)
{
int happines=0,flag=0,flag1=0,kx=0,hcheck=0,fg;
//struct time_table *happiest_time_table;
struct time_table  *curr_ptr;
int generations = 0;
int num_of_generation = 0;


/*if (( (happiest_time_table) =(struct time_table  *)malloc(sizeof(struct time_table)))== NULL)
       {
       printf("\ninsufficient memory for TT allocation \n");
       exit(8);
       }
       happiest_time_table->next=NULL;
*/
char  constraint_file_name[] = "csll.ctr";
char  out_file_name[] = "out.pop";
char out_happy_name[]="happy.pop";
char out_unhappy_name[]="unhappy.pop";
char out_lab_name[]="lab.pop";
char out_ulab_name[]="ulab.pop";
char out_tut_name[]="tut.pop";
char out_utut_name[]="utut.pop";
if (initialise_constraints(constraint_file_name)!=0)
exit(1);
cout<<"done1\n";
//getch();
//randomize();
population_size = max_population_size;
cout<<"done2\n";
//getch();
if (initialise_colony()!=0)
exit(2);
if (find_average_cost()!=0)
exit(3);
cout<<"done sucess\n";

curr_ptr=solution_colony.first_time_table;
while(curr_ptr!=NULL)
{
   cout<<curr_ptr->cost;
   curr_ptr=curr_ptr->next;
   cout<<"\n";
}
cout<<"ha ha "<<solution_colony.last_time_table->cost;
/*
 * repeat until a perfect time table is found and will check the maxium happiness in 10000 trials
 */
while ((solution_colony.first_time_table -> cost> maximum_allowed_cost) ||(hcheck<=9999))
{
hcheck++;
/*  calculate the happiness factor of the first generated time table if the cost is less than the maximum allowed cost 
*/
if( solution_colony.first_time_table -> cost<=maximum_allowed_cost)
{ happines=happiness1(solution_colony.first_time_table);
cout<<"\nCurrent happines = "<<happines<<"\n";
//getch();
  if(happines>=flag)
  {   flag=happines; 
      kx++;
      if(output_happy(out_happy_name)!=0)
          exit(8);
      if(output_lab(out_lab_name)!=0)
      exit(9);
       if(output_tut(out_tut_name)!=0)
      exit(9);
  cout<<"Maximum Happiness = $"<<(flag/10)<<(flag%10)<<"\n"; 
 cin>>fg;
 //getch();
}
if(kx==1)
{
flag1=flag;
 if(output_happy(out_unhappy_name)!=0)
 exit(9);
 if(output_lab(out_ulab_name)!=0)
      exit(9);
       if(output_tut(out_utut_name)!=0)
      exit(9);
 }//getch();
 
 if(happines<flag1)
 {
 if(output_happy(out_unhappy_name)!=0)
 exit(9);
  if(output_lab(out_ulab_name)!=0)
      exit(9);
      if(output_tut(out_utut_name)!=0)
      exit(9);
  }
  
}
  

/*
 * kill off the costliest half of the population
 */

if (kill_costly_colony_members()!=0)
exit(4);
/*
 * find the average cost of the population.
 */
if (find_average_cost()!=0)
exit(5);
/*
 * breed the population back up to full size.
 */

                           
while (solution_colony.population_size<max_population_size)
{
num_of_trials= num_of_trials +1;
if (breed_colony()!=0)
exit(6);

}
num_of_generation++;
/*
 * Output the current status to the screen.
 */
printf("  %d ",(solution_colony.average_cost));
printf("  %d ",num_of_trials);
cout<<"  >"<<(num_of_generation/10000)<<((num_of_generation/1000)%10)<<((num_of_generation/100)%10)<<(((num_of_generation/10)%100)%10)<<(num_of_generation%10)<<" ";

printf("  (%d) \n",solution_colony.first_time_table -> cost);
num_of_trials = 0;

///////trial
curr_ptr=solution_colony.first_time_table;
/*while(curr_ptr!=NULL)
{
   cout<<curr_ptr->cost;
   curr_ptr=curr_ptr->next;
   cout<<"\n";
}*/
//getch();


////////
}

/*
 *  output the colony to a ".pop" text file
 */
if (output_colony(out_file_name) !=0)
exit(7);

printf("\nfinished after %d generations_|\n",num_of_generation);
return(0);
}



/*
 * fget_string-
 *
 * used for getting a string from a file
 *
 */
int fget_string(FILE *in, char wordy[80])
{
int prevcha = 'a';
int count = 0;
while ((prevcha != '\n') && (!feof(in))) {
prevcha = fgetc(in);
if (prevcha != '\n') {
wordy[count]=prevcha;
count++;
}
}
wordy[count] = '\0';
//cout<<wordy;
//getch();
return 0;
}
/*
 * value_of-
 *
 * returns the integer values of a string.
 */
int value_of(char wordy[80])
{
int a;
int count = 0;
int val = 0;
int row = 0;
while(wordy[count]!='\0')
count++;
for (a=0; a<count; a++){
val = val+int(((wordy[count-a-1]-'0')) *pow(10, row));
row++;
}
return val;
}




int fget_line_value(FILE *in)
{int a;
char wordy[80];
fget_string(in, wordy);
a= value_of(wordy);
//cout<<a<<"\n";
//getch();
return a;
}


///////////////////////
int fgetc_value(FILE *in)
{
char ch;
ch = fgetc(in);
int k=(ch - '0');
//cout<<k;
//getch();
return k;
}
/*
 * initialise_constraints-
 *
 *
 * PRE: the file references by file_name_type contains valid constraint
 * data
 *
 * POST: All class constraints, lecturer constraints and room
 *       constraints are loaded from the file.
 *
 */
int initialise_constraints(file_name_type constraint_file_name)
{
FILE *in;
char wordy[80];
char prevcha;
int a = 0;
int day, hour;
if ((in = fopen(constraint_file_name, "rt")) == NULL)
{
fprintf(stderr, "Cannot open input file\n");
return 1;
}

fget_string(in,wordy);
fget_string(in,wordy);
class_constraints.num_of_classes = fget_line_value(in);
class_constraints.num_of_class_associations = fget_line_value(in);

/*
 * read all data about class constraints from the file.
 */


for (a = 1; a <= ((class_constraints.num_of_classes)); a++)
 {
	fget_string(in,class_constraints.classes[a].name_of_class);
	class_constraints.classes[a].reference_num_of_lecturer= fget_line_value(in);
	class_constraints.classes[a].batch=fget_line_value(in);
	class_constraints.classes[a].size_of_class= fget_line_value(in);
	class_constraints.classes[a].home_office_location_of_class[1]= fget_line_value(in);
	class_constraints.classes[a].home_office_location_of_class[2]= fget_line_value(in);
	class_constraints.classes[a].associated_class_code= fget_line_value(in);
		//fget_string(in,wordy);
	}
	//cout<<" the class completed";
	//getch();
fget_string(in,wordy);
prac_constraints.num_of_pracs = fget_line_value(in);
for (a = 1; a <= ((prac_constraints.num_of_pracs)); a++)
 {
	fget_string(in,prac_constraints.pracs[a].name_of_prac);
	prac_constraints.pracs[a].reference_lab_num= fget_line_value(in);
	prac_constraints.pracs[a].batch=fget_line_value(in);
	prac_constraints.pracs[a].prac_size= fget_line_value(in);
		//fget_string(in,wordy);
	}
fget_string(in,wordy);
tut_constraints.num_of_tuts=fget_line_value(in);
for (a = 1; a <= ((tut_constraints.num_of_tuts)); a++)
 {
	fget_string(in,tut_constraints.tuts[a].name_of_tut);
    tut_constraints.tuts[a].batch=fget_line_value(in);

		//fget_string(in,wordy);
	}
	
class_constraints.classes[0].reference_num_of_lecturer = 0;
class_constraints.classes[0].size_of_class = 0;
class_constraints.classes[0].associated_class_code = 0;
class_constraints.classes[0].batch=0;


prac_constraints.pracs[0].reference_lab_num = 4;
prac_constraints.pracs[0].prac_size= 0;
prac_constraints.pracs[0].batch=0;

tut_constraints.tuts[0].batch=0;


fget_string(in,wordy);
lecturer_constraints.num_of_lecturers = fget_line_value(in);

for (a = 0; a < lecturer_constraints.num_of_lecturers; a++)
{
	fget_string(in,lecturer_constraints.lecturers[a].name_of_lecturer);
	lecturer_constraints.lecturers[a].home_office_location_of_lecturer[1]= fget_line_value(in);
	lecturer_constraints.lecturers[a].home_office_location_of_lecturer[2]= fget_line_value(in);

	for (day = 0; day < days_in_week; day++)
		 {
			for (hour=0; hour<hours_in_day; hour++)
			{
				lecturer_constraints.lecturers[a].availability_time_table_of_lecturer[day][hour]= fgetc_value(in);
			}
			//cout<<"\n";
		fget_string(in,wordy);
		}

}
//cout<<"lecturers done";
//getch();
fget_string(in,wordy);
room_constraints.num_of_rooms = fget_line_value(in);

for (a = 0; a<room_constraints.num_of_rooms; a++)
{
	fget_string(in, room_constraints.rooms[a].name_of_room);
		room_constraints.rooms[a].capacity_of_room =fget_line_value(in);
		room_constraints.rooms[a].location_of_room[1] =fget_line_value(in);
		room_constraints.rooms[a].location_of_room[2] = fget_line_value(in);
		for (day = 0; day < days_in_week; day++)
		{
			for (hour = 0; hour<hours_in_day; hour++)
			 {
					room_constraints.rooms[a].availability_time_table_of_room[day][hour]= fgetc_value(in);
				}
		//	cout<<"\n";
            fget_string(in,wordy);
		}

}
fget_string(in,wordy);
lab_constraints.num_of_labs = fget_line_value(in);

for (a = 0; a<lab_constraints.num_of_labs; a++)
{
	fget_string(in, lab_constraints.rooms[a].name_of_room);
		lab_constraints.rooms[a].capacity_of_room =fget_line_value(in);
		lab_constraints.rooms[a].location_of_room[1] =fget_line_value(in);
		lab_constraints.rooms[a].location_of_room[2] = fget_line_value(in);
		for (day = 0; day < days_in_week; day++)
		{
			for (hour = 0; hour<hours_in_day; hour++)
			 {
					lab_constraints.rooms[a].availability_time_table_of_room[day][hour]= fgetc_value(in);
				}
		//	cout<<"\n";
            fget_string(in,wordy);
		}

}
//cout<<wordy<<"sucess";
//getch();
fclose(in);
return(0);
}
/*
 * repair_strategy-
 *
 * Performs the second stage of repair to the timetable pointed to
 * by curr_ptr
 *
 * PRE: Each class is booked zero or more times
 *
 * POST: Each class is booked either zero times or one time.
 *
 */
int repair_strategy(struct time_table  *curr_ptr)
{
/*
 PRE: Each class can appear 0 times, 1 time or 2 times in a timetable
 POSSIBLE PRE: Maybe a class can appear more than twice- two reasons:57
may want to have more than two parents. May help in making
this a simple "random population" high cost time table generator.
 POST: It must be true that for each class there is one and only one
 booking for it in a week.
  Any class which is not booked exactly once must be corrected.
 A suggested style for doing this is as follows:
 */
struct booking_location {
int which_room;
int which_day;
int which_hour;
struct booking_location  *next;
};
struct booking_location  *first;
struct booking_location  *curr_booking;
struct booking_location  *booking_to_remove;
int cur_class;
int class_occurred;
int cur_room;
int day;
int hour;
int one_to_remove;
char chr;
int a = 0;
for (cur_class=1; cur_class<=class_constraints.num_of_classes; cur_class++)
{
  class_occurred = 0;
   for (cur_room = 0; cur_room<room_constraints.num_of_rooms;cur_room++)
   for (day = 0; day<days_in_week; day++)
   for (hour = 0; hour<hours_in_day; hour++)
  {
    if (curr_ptr -> bookings[cur_room][day][hour] ==cur_class)
     {
        class_occurred++;
       if (class_occurred == 1) 
       {if (( (first) =(struct booking_location *)malloc(sizeof(struct booking_location)))== NULL) {
         printf("\n insufficient memory for this booking\n");
          exit(8);
        }
      curr_booking = first;
     }
     
    else {if (( (curr_booking->next) =(struct booking_location  *)malloc(sizeof(struct booking_location)))== NULL)
      {printf("\n insufficient memory for booking allocation \n");
        exit(1);
      }
      curr_booking = curr_booking -> next;
     }
   curr_booking -> which_room = cur_room;
   curr_booking -> which_day = day;
   curr_booking -> which_hour = hour;
   }
   
}
if (class_occurred == 1) 
   {free(first);
    }
 else
if (class_occurred > 1 )
{ //cout<<"++"<<class_occurred;
  //getch();
  while (class_occurred > 1) 
  { curr_booking = first;
    one_to_remove = random(class_occurred);
       for (a=0;a<one_to_remove;a++)
        { curr_booking = curr_booking -> next;
         }
      cur_room = curr_booking -> which_room;
         day = curr_booking -> which_day;
       hour = curr_booking -> which_hour;
   if (curr_ptr -> bookings [cur_room] [day] [hour]== cur_class)
    { curr_ptr -> bookings [cur_room] [day] [hour] = 0;
        if (one_to_remove == 0)
         { booking_to_remove = first;
           first = first -> next;
          }
  else
  if (one_to_remove != 0)
   {
       curr_booking = first;
        for (a=0; a<(one_to_remove-1); a++){
          curr_booking = curr_booking -> next;
   }
    booking_to_remove = curr_booking -> next;
    curr_booking -> next = (curr_booking -> next)-> next;
   }
free(booking_to_remove);
class_occurred --;
 //cout<<" + "<<class_occurred;
    }

}
free(first);
//getch();
}
}

return(0);
}
/*
 * repair_strategy_0-
 *
 * Performs the second stage of repair to the timetable pointed to
 * by curr_ptr
 *
 * PRE: Each class is booked either zero times or one time
 *
 * POST: Each class is booked precisely once.59
 *
 */
int repair_strategy_0(struct time_table  *curr_ptr)
{
int cur_class;
int class_occurred;
int cur_room;
int day,flag=0;
int hour;
 int one_to_remove;
 char chr;
 for (cur_class=1; cur_class<=class_constraints.num_of_classes; cur_class++) 
  { 
      class_occurred = 0;
      for (cur_room = 0; cur_room<room_constraints.num_of_rooms;cur_room++)
      for (day = 0; day<days_in_week; day++)
      for (hour = 0; hour<hours_in_day; hour++) 
      {
           if ((curr_ptr ->bookings [cur_room][day][hour]== cur_class) && 
           class_constraints.classes[curr_ptr ->bookings [room_constraints.num_of_rooms-(1+cur_room)][day][hour]].batch!=
           class_constraints.classes[cur_class].batch )
           {
            class_occurred++;
            }
      }
      if (class_occurred == 0) 
      {
            while (class_occurred == 0)
            { 
             flag=0;
             day  = random(days_in_week);
             hour = random(hours_in_day);
             for (cur_room = 0; cur_room<room_constraints.num_of_rooms;cur_room++)
                  {  if (curr_ptr ->bookings [cur_room] [day] [hour] == 0||class_constraints.classes[curr_ptr ->bookings [cur_room][day][hour]].batch!=
           class_constraints.classes[cur_class].batch)
                     flag=1;
                     else
                     flag=0;
                   }
                   if(flag==1)
                   { cur_room = random(room_constraints.num_of_rooms);
                    curr_ptr ->bookings [cur_room] [day] [hour]= cur_class;
                     class_occurred ++;
                    }
              }
         }
 }

return(0);
}


 /*related classes-
 *
 * counts the number of times that related classes are booked
 * at the same time in the timetable pointed to by curr_ptr
 *
 */
long related_classes(struct time_table  *curr_ptr)
{
int num_of_occurrences=0;
int curr_class_group = 0;
int this_group_has_occurred = 0;
int curr_room;
int curr_day;
int hour;
int this_class_group;
int this_class_num;
for (curr_class_group = 1;curr_class_group <=class_constraints.num_of_class_associations;curr_class_group ++)
 {
for (curr_day=0; curr_day < days_in_week; curr_day++) {
for (hour=0; hour< hours_in_day; hour++) {
this_group_has_occurred = 0;
for (curr_room = 0;curr_room < room_constraints.num_of_rooms;curr_room ++) {
this_class_num =(curr_ptr ->bookings[curr_room][curr_day][hour]);
if (this_class_num!=0)
 {
      this_class_group =class_constraints.classes[this_class_num].associated_class_code;
      if(this_class_group == curr_class_group) 
      {
                          this_group_has_occurred ++;
      }
 }
}
if (this_group_has_occurred>1) {
num_of_occurrences +=(this_group_has_occurred-1);
}
}
}
}
return num_of_occurrences;
}
/*
 * room_too_small-
 *
 * counts the number of times a class is booked to a room which is
 * too small for it in the timetable pointed to by curr_ptr
 *
 */
long room_too_small(struct time_table  *curr_ptr)
{
int num_of_occurrences=0;
int curr_room;
class_size_type curr_size_available;
class_size_type curr_size_allocated;
int curr_day;
class_num  curr_class;
int hour;
for (curr_room=0;     curr_room < room_constraints.num_of_rooms; curr_room ++)
{
curr_size_available =room_constraints.rooms[curr_room].capacity_of_room;

for (curr_day=0; curr_day < days_in_week; curr_day++)

for (hour=0; hour< hours_in_day; hour++)
{
curr_class = curr_ptr ->bookings [curr_room][curr_day][hour];

if (curr_class != 0)
 {
curr_size_allocated =
class_constraints.
classes[curr_class].
size_of_class;
if (curr_size_available
   < curr_size_allocated) {
num_of_occurrences ++;
}
}
}
}
return num_of_occurrences;
}
/*
 * lecturer_double_booked-
 *
 * counts the number of times a lecturer is double booked in the
 * timetable pointed to by curr_ptr
 *
 */
long lecturer_double_booked(struct time_table  *curr_ptr)
{
int num_of_occurrences=0;
int curr_room;
int lecturer_num;
int curr_lecturer;
int num_of_bookings_at_this_time;
int current_lecturer_is;
struct classr current_class_is;
int curr_class;
int curr_class_num;
int curr_day;
int hour;
for (lecturer_num = 0; lecturer_num < lecturer_constraints.num_of_lecturers; lecturer_num++)
 {
   for (curr_day = 0; curr_day < days_in_week; curr_day++)
   for (hour = 0; hour< hours_in_day; hour++)
   {
    num_of_bookings_at_this_time = 0;
for (curr_room = 0;curr_room < room_constraints.num_of_rooms;curr_room ++)
{
curr_class_num =(curr_ptr ->bookings[curr_room][curr_day][hour]);
if (curr_class_num!=0)
{
curr_lecturer =class_constraints.classes[curr_class_num].reference_num_of_lecturer;
if (curr_class_num != 0)
 {
if (lecturer_num ==curr_lecturer)
 {
 num_of_bookings_at_this_time++;
}
}
}
if (num_of_bookings_at_this_time>1) {
num_of_occurrences
+=(num_of_bookings_at_this_time-1);
}
}
}
}
return num_of_occurrences;
}
/*
 * lecturer_unavailable -
 *
 * returns the number of violations of the constraint
 * "Lecturer's cannot be booked when they have prior commitments."
 * in the timetable pointed to by curr_ptr.
 *
 */
long lecturer_unavailable(struct time_table  *curr_ptr)
{
int num_of_occurrences=0;
int curr_room;
int lecturer_num;
int curr_lecturer;
int current_lecturer_is;
struct classr current_class_is;
int curr_class;
int curr_class_num;
int curr_day;
int hour;

for (curr_day=0; curr_day < days_in_week; curr_day++)
for (hour=0; hour< hours_in_day; hour++)
{
 for (curr_room=0; curr_room< room_constraints.num_of_rooms; curr_room ++)
 {
 curr_class_num= (curr_ptr -> bookings[curr_room][curr_day][hour]);
 
   if (curr_class_num != 0) 
   {
    curr_lecturer =class_constraints.classes[curr_class_num].reference_num_of_lecturer;
                  if (lecturer_constraints.lecturers[curr_lecturer].availability_time_table_of_lecturer[curr_day][hour] == 0)
                   {
                     num_of_occurrences++;
                   }
    }
  }
}
return num_of_occurrences;
}


/* we need to check wether the timetable generated with the cost
equal to the 0 can be able to allocate the practical on the lab
checking wether students are free of therir lectures and check wether the 
labss are free*/

long lab_nalloc(struct time_table * curr_ptr)
{ int a,day,hour,room,alloc,k=0,flag=0,hooked=1;
    
     for (a = 0; a<lab_constraints.num_of_labs; a++)
     for (day = 0; day < days_in_week; day++)
     for (hour = 0; hour < hours_in_day; hour++)
     curr_ptr -> lbookings[a][day][hour]= 0;
     //cout<<" ,."<<prac_constraints.num_of_pracs;getch();
     for (a = 1; a <=prac_constraints.num_of_pracs; a++)
      {     alloc=0;flag=0;hooked=1;
      
            for(day=0;day< days_in_week ;day++)
            { for(hour=1;hour<((hours_in_day-1));hour++)
               
              { alloc=0;flag=0;hooked=1;
                 if((curr_ptr->lbookings[prac_constraints.pracs[a].reference_lab_num][day][hour]==0)&&(curr_ptr->lbookings[prac_constraints.pracs[a].reference_lab_num][day][hour+1]==0))
                  { for(room=0; room<room_constraints.num_of_rooms; room++)
                    {//if((curr_ptr->bookings[room][day][hour]==0) &&(curr_ptr->bookings[room][day][hour+1]==0)&&hooked==1)
                     if((class_constraints.classes[curr_ptr->bookings[room][day][hour]].batch!=prac_constraints.pracs[a].batch)
                      &&(class_constraints.classes[curr_ptr->bookings[room][day][hour+1]].batch!=prac_constraints.pracs[a].batch)&&hooked==1)
                      
                        flag=1;
                      
                        else
                        {flag=0;hooked=0;}
                     }
                     for (int lab = 0; lab<lab_constraints.num_of_labs; lab++)  
                  {
                  if((prac_constraints.pracs[(curr_ptr->lbookings[lab][day][hour])].batch!=prac_constraints.pracs[a].batch)&&hooked==1)                                   
                      flag=1;
                      
                      else
                      {flag=0;hooked=0;}
                   }  
                 }      
               if(flag)
               {alloc=1;
                        curr_ptr->lbookings[prac_constraints.pracs[a].reference_lab_num][day][hour]=a;
                        curr_ptr->lbookings[prac_constraints.pracs[a].reference_lab_num][day][hour+1]=a;
                        //cout<<",,,"<<curr_ptr->lbookings[prac_constraints.pracs[a].reference_lab_num][day][hour+1]<<k;getch();
               hour++;
               }
               if(day==5&&hour==3)
                 hour=8;   
               if(hour==3)
               hour++;
               if(alloc)
               break;
              }
              if(alloc)
              break;   
             }
             if(!alloc) k++;
        }        
     if(k==0){//cout<<"gotcha";getch();
     return 0;}
     else
     {//output_debug(curr_ptr);
     return k;
     }
   }
     
   ////////////////////////////////////////////////////////////////
   //////////////////////
   //////////////
   ///////////////////////////////////////////////
   long tut_nalloc(struct time_table * curr_ptr)
{ int a,day,hour,room,alloc,k=0,flag=0,hooked=1,roomn,roomgotcha;
    
     for (a = 0; a<room_constraints.num_of_rooms; a++)
     for (day = 0; day < days_in_week; day++)
     for (hour = 0; hour < hours_in_day; hour++)
     curr_ptr -> tbookings[a][day][hour]= 0;
     //cout<<" ,."<<prac_constraints.num_of_pracs;getch();
     for (a = 1; a <=tut_constraints.num_of_tuts; a++)
      {                 
            for(day=0;day< days_in_week ;day++)
            { for(hour=0;hour<((hours_in_day));hour++)
                 { alloc=0;flag=0;hooked=1,roomgotcha=0;
                     for(room=0; room<room_constraints.num_of_rooms; room++)
                   { if((class_constraints.classes[curr_ptr->bookings[room][day][hour]].batch)!=(tut_constraints.tuts[a].batch)&&
                                          
                     //if (class_constraints.classes[curr_ptr->bookings[room][day][hour]].batch==0
                     (tut_constraints.tuts[curr_ptr->tbookings[room][day][hour]].batch)!=(tut_constraints.tuts[a].batch)&&
                      //&&(curr_ptr->tbookings[room][day][hour]==0)
                      (hooked==1))                                                    
                      { if(curr_ptr->tbookings[room][day][hour]==0&&curr_ptr->bookings[room][day][hour]==0)
                         {roomgotcha=1;roomn=room;
                          }
                       flag=1;
                       
                       }
                      
                      else
                      { 
                        
                          flag=0;hooked=0;}
                   }
                   
                 for (int lab = 0; lab<lab_constraints.num_of_labs; lab++)  
                  {
                  if((prac_constraints.pracs[(curr_ptr->lbookings[lab][day][hour])].batch!=tut_constraints.tuts[a].batch)&&hooked==1)                                   
                      flag=1;
                      
                      else
                      {flag=0;hooked=0;}
                   }    
               if(flag==1&&roomgotcha==1)
               {alloc=1;
                        curr_ptr->tbookings[roomn][day][hour]=a;
                        
                        
               
               }
               if(day==5&&hour==3)
                 {hour=8;   
                 }
               if(alloc)               
                break;
                
              }
              if(alloc)
               break; 
                
             }
             if(!alloc){ k++;}
        }        
     if(k==0){//cout<<"gotcha";getch();
     return 0;}
     else
     {//output_debug(curr_ptr);
     return k;
     }
   }  
     
     
     
     
     
     
      
/*
 * calculate_cost-
 *
 * calculate_cost determines the cost of the timetable pointed to
 * by curr_ptr. The number of violations of each constraint is
 * multiplied by the weighting for that constraint and added to
 * the total.
 *
 */
int calculate_cost(struct time_table  *curr_ptr)
{


cost_type the_cost = 0;
cost_type problem1;
cost_type problem2;
cost_type problem3;
cost_type problem4;
cost_type problem5=0;
cost_type problem6=0;
struct time_table *spare_ptr;
spare_ptr = curr_ptr;
spare_ptr -> cost = 0;

curr_ptr -> rcc_error_count = related_classes(curr_ptr);
curr_ptr -> rts_error_count = room_too_small(curr_ptr);
curr_ptr -> ldb_error_count = lecturer_double_booked(curr_ptr);
curr_ptr -> lua_error_count = lecturer_unavailable(curr_ptr);
curr_ptr -> lab_error_count = lab_nalloc(curr_ptr);
curr_ptr -> tut_error_count = tut_nalloc(curr_ptr);
problem5=(curr_ptr -> lab_error_count);

problem6=(curr_ptr -> tut_error_count);
problem1 = (curr_ptr ->rcc_error_count * cost_of_related_class_clash);
problem2 = (curr_ptr ->rts_error_count * cost_of_room_too_small);
problem3 = (curr_ptr ->ldb_error_count * cost_of_lecturer_double_booked);
problem4 = (curr_ptr ->lua_error_count * cost_of_unavailable_lecturer);
//the_cost = problem1 + problem2 + problem3 + problem4;
/*if(the_cost<=maximum_lab_cost)
{ 
curr_ptr -> lab_error_count = lab_nalloc(curr_ptr);
problem5=(curr_ptr -> lab_error_count);
}*/
printf("              ");
printf(" %4d", problem1);
printf(" %5d", problem2);
printf(" %5d", problem3);
printf(" %5d ", problem4);
printf(" %5d ", problem5);
printf(" %5d ", problem6);

the_cost = problem1 + problem2 + problem3 + problem4+problem5+problem6;
curr_ptr -> cost = the_cost;


return(0);
}
/*
 * fputn -
 *
 * used for writing an integer from 0 to 999 into a file.
 *
 */
void fputn(int a, FILE *fp)
{
int b;
b=a;
if (b>99) {
b = b % 100;
b = (a-b) / 100;
fputc(b+48, fp);
b = a - (b*100);
} else
fputc(48, fp);
if (b>9) {
a = b;
b = b % 10;
b = (a - b) / 10 ;
fputc(b+48, fp);
b = a - (b*10);
} else
fputc(48, fp);
fputc(b+48, fp);
fputc('\n', fp);
}
/*
 * initialise_colony -
 *
 * creates a random population by repairing NULL timetables.
 *
 */
int initialise_colony(void)
{
 struct time_table  *curr_ptr;
 struct time_table  *lagging_ptr;
 struct time_table  *test_tube;
 char wordy[80];
 int solution, cur_room,day,hour;
 int final_population_size;
 solution_colony.population_size = 0;
 final_population_size = population_size;
 while (solution_colony.population_size < final_population_size) 
{      
       if (( (test_tube) =(struct time_table  *)malloc(sizeof(struct time_table)))== NULL)
       {
       printf("\ninsufficient memory for TT allocation \n");
       exit(8);
       }
  
//  cout<<"done memory";
  //getch();
if (test_tube -> next != NULL)
 {
   test_tube -> next = NULL;
 //cout<<"donem1";
//etch();
 }

for (cur_room = 0; cur_room < room_constraints.num_of_rooms;cur_room++)
for (day = 0; day < days_in_week; day++)
for (hour = 0; hour < hours_in_day; hour++)
(test_tube ->bookings[cur_room][day][hour]) = 0;
//cout<<"reapiring";
//getch();
repair_strategy_0(test_tube);
calculate_cost(test_tube);
cout<<"returned and clll";
/////////////////////////////////////////////////////////////
if (solution_colony.population_size == 0) 
{
solution_colony.first_time_table = test_tube;
solution_colony.last_time_table = test_tube;
solution_colony.population_size++;
} 

else 
     {if(solution_colony.population_size == 1)
       { if(solution_colony.first_time_table->cost<test_tube->cost)
          {solution_colony.first_time_table->next=test_tube;
          solution_colony.last_time_table=test_tube;
          cout<<"true 1";
          }
          else{test_tube->next=solution_colony.last_time_table;
               solution_colony.first_time_table=test_tube;
               }
               solution_colony.population_size++;
        }
 else{
      curr_ptr = solution_colony.first_time_table;
      if (curr_ptr -> cost  >= test_tube -> cost)
       {
       test_tube -> next = curr_ptr;
       solution_colony.first_time_table = test_tube;
       solution_colony.population_size++;
       }
        else 
        {
         curr_ptr = solution_colony.first_time_table;
                  while ((curr_ptr -> next != NULL)&&(curr_ptr-> next-> cost <= test_tube -> cost))
                        {cout<<"true1111";
                         if (curr_ptr -> next != NULL) 
                         {
                         curr_ptr = curr_ptr -> next;
                         }
                         };
          if (curr_ptr ==solution_colony.last_time_table)
           {cout<<"true";
                       test_tube -> next = NULL;
                       curr_ptr->next=test_tube;
            solution_colony.last_time_table = test_tube;

            }
             else
              {
              test_tube -> next = curr_ptr -> next;
              curr_ptr->next = test_tube;
              }
              solution_colony.population_size++;
     }
 }
}
solution_colony.last_time_table -> next = NULL;
curr_ptr = solution_colony.first_time_table;

}

 return(0);
}
/*
 * find_average_cost -
 *
 * Finds mean of the cost of each timetable
 * The result is entered in the colonies average cost field.
 *
 *
 */
int find_average_cost(void)
{
cost_type  sum_of_costs = 0;
cost_type  sum_of_error1 = 0;
cost_type  sum_of_error2 = 0;
cost_type  sum_of_error3 = 0;
cost_type  sum_of_error4 = 0;
struct time_table  *curr_ptr;
long a;
curr_ptr = solution_colony.first_time_table;
a=0;
while (curr_ptr != NULL) {
a++;
sum_of_costs += curr_ptr -> cost;
sum_of_error1 += curr_ptr -> rcc_error_count;
sum_of_error2 += curr_ptr -> rts_error_count;
sum_of_error3 += curr_ptr -> ldb_error_count;
sum_of_error4 += curr_ptr -> lua_error_count;
curr_ptr = curr_ptr-> next;
}
solution_colony.average_cost =
(sum_of_costs / (solution_colony.population_size));
solution_colony.rcc_error_count =
(sum_of_error1 / (solution_colony.population_size));
solution_colony.rts_error_count =
(sum_of_error2 / (solution_colony.population_size));
solution_colony.ldb_error_count =
(sum_of_error3 / (solution_colony.population_size));
solution_colony.lua_error_count =
(sum_of_error4 / (solution_colony.population_size));
return(0);
}
typedef struct colony_cost_statistics {
cost_type costs[max_population_size];
cost_type average_cost;
cost_type median_cost;
cost_type fatal_cost;
};
/*
 * kill_costly_colony_members -
 *
 * The colony is already order from least costly to most costly.
 * Decide what number of people to kill (x).
 * find the (pop-x)th creature. Make them the "last" in line.
 * free each creature after that.
 *
 */
int kill_costly_colony_members()
{
    
    
int amount_to_kill;
float kill_ratio = 0.5; //need not be integer.
struct time_table  *curr_ptr;
struct time_table  *lagging_ptr;
int a;


amount_to_kill = int(solution_colony.population_size * kill_ratio);

while (solution_colony.population_size-amount_to_kill < 2) 
{
amount_to_kill--;
}
curr_ptr = solution_colony.first_time_table;

for (a=0; a<(solution_colony.population_size-amount_to_kill)-1;a++)
{
curr_ptr = curr_ptr ->next;
}
solution_colony.last_time_table = curr_ptr;
curr_ptr = curr_ptr -> next;
solution_colony.last_time_table -> next = NULL;

do {
lagging_ptr = curr_ptr;
curr_ptr = curr_ptr -> next;
free(lagging_ptr);
solution_colony.population_size--;
} 
while (curr_ptr != NULL);
return(0);
}
/*
 * pop_size -
 *
 * used for verifying that the population's size is correctly recorded.
 */
int pop_size()
{
int a=0;
struct time_table  *curr_ptr;
curr_ptr = solution_colony.first_time_table;
while (curr_ptr != NULL) {
a++;
curr_ptr = curr_ptr -> next;
}
return a;
}
/*68
 * mutate -
 *
 * Performs mutations on a child.
 * Probability that a gene will undergo mutation is (2*mutation_rate)/1000
 * Method of mutation is to randomly switch any two genes.
 *
 */
int mutate(struct time_table  *curr_ptr)
{
class_num temporary;
int cur_room;
int cur_day;
int cur_hour;
int random_room;
int random_day;
int random_hour;
for (cur_room = 0; cur_room<room_constraints.num_of_rooms;cur_room++)
for (cur_day = 0; cur_day<days_in_week; cur_day++)
for (cur_hour = 0;cur_hour < hours_in_day; cur_hour++)
{
if (random(1000)<mutation_rate)
 {
temporary =curr_ptr -> bookings[cur_room] [cur_day][cur_hour];
random_room = random(room_constraints.num_of_rooms);
random_day = random(days_in_week);
random_hour = random(hours_in_day);
curr_ptr -> bookings[cur_room][cur_day][cur_hour] =curr_ptr -> bookings[random_room][random_day][random_hour];
curr_ptr -> bookings[random_room][random_day][random_hour]=temporary;
}
}
return(0);
}
/*
 * breed_colony -
 *
 * selects two members of the population, at random, to act as
 * parents.
 * Their genetic makeup using cross over, to produce a child
 * The child is mutated, repaired and evaluated before being placed
 * in the populatio.
 *
 */
int breed_colony()
{
int cross_over_rate = 2;
struct time_table  *mother;
struct time_table  *father;
struct time_table  *test_tube;
struct time_table  *curr_ptr;
int mother_pos;
int father_pos;
int a;
int cur_room;
int day;
int hour;
int state=0;
printf("* %3d", num_of_trials);

do{mother_pos = random(solution_colony.population_size);

father_pos = random(solution_colony.population_size);

}while (mother_pos != father_pos);

mother = solution_colony.first_time_table;

for (a=0; a<mother_pos; a++)
    {
    mother = mother -> next;
    }
father = solution_colony.first_time_table;

for (a=0; a<father_pos; a++)
    {
    father = father -> next;
    }
if (( test_tube = (struct time_table*)malloc(sizeof(struct time_table))) == NULL) 
   {
printf("\n insufficient memory for TT \n");
exit(9);
        }


state=random(2)+1;

for (day = 0; day<days_in_week; day++) 
{
    for (hour = 0; hour<hours_in_day; hour++) 
        {
         for (cur_room = 0; cur_room<room_constraints.num_of_rooms;cur_room++)
             {
              if (state==1) 
              {
               test_tube ->bookings [cur_room] [day] [hour] =mother ->bookings [cur_room] [day] [hour];
               if (random(cross_over_rate)==0)
                {
                 state = 2;
                 }
               }
               else {
                    test_tube ->bookings [cur_room] [day] [hour] =father ->bookings[cur_room] [day] [hour];
                    if (random(cross_over_rate)==0)
                     {
                      state = 1;
                      }
              }
         }
    }
}
mutate(test_tube);
repair_strategy(test_tube);
repair_strategy_0(test_tube);
calculate_cost(test_tube);



{
 printf("      ......cost= %8d\n", test_tube -> cost);
 curr_ptr = solution_colony.first_time_table;
 
 if (curr_ptr -> cost  >= test_tube -> cost)
  {
   test_tube -> next = curr_ptr;
   solution_colony.first_time_table = test_tube;
   solution_colony.population_size++;
   }
   
    else 
    {
         
    curr_ptr = solution_colony.first_time_table;

    while ((curr_ptr -> next != NULL)&&(curr_ptr-> next-> cost < test_tube -> cost) )
    { //cout<<"0";
          if (curr_ptr -> next != NULL) 
          { 
          curr_ptr = curr_ptr -> next;
           
          }
    };
    
    if (curr_ptr == solution_colony.last_time_table)
    {//cout<<"at last";
     test_tube -> next = NULL;
     curr_ptr->next=test_tube;
     solution_colony.last_time_table= test_tube;
     }
     
      else 
      { 
           //cout<<"at middle";
           test_tube -> next = curr_ptr -> next;
           curr_ptr->next = test_tube;
      }
      solution_colony.population_size++;
}
}

return(0);
}
/*
 * output_colony -
 *
 * Outputs all genes of all creatures to a ".pop" text file.
 * They can be later retrieved and used as an initialisation point.
 *
 */
int output_colony(file_name_type out_file_name)
{
        FILE *out;
        struct time_table  *curr_ptr;
        int cur_room, day, hour;
        if ((out = fopen(out_file_name, "w")) == NULL) 
        {
        fprintf(stderr, "Cannot open output file\n");
        return 1;
        }
curr_ptr = solution_colony.first_time_table;
//while ((curr_ptr->next)  != NULL)
{      for (cur_room = 0; cur_room<room_constraints.num_of_rooms;cur_room++)
        for (day = 0; day<days_in_week; day++)
        for (hour = 0; hour<hours_in_day; hour++)
        {
        fputn(curr_ptr -> bookings[cur_room][day][hour],out);
        //cout<<curr_ptr -> bookings[cur_room][day][hour];
        //getch();
        }
        //curr_ptr = (curr_ptr -> next);
}
fclose(out);
return(0);
}

int output_happy(file_name_type out_happy_name)
{
        FILE *out,*out1;
        struct time_table  *curr_ptr;
        char c;
        int t,cur_room, day, hour;
        if ((out = fopen(out_happy_name, "w")) == NULL||(out1=fopen("happyv","w"))==NULL) 
        {
        fprintf(stderr, "Cannot open output file\n");
        return 1;
        }
        curr_ptr = solution_colony.first_time_table;
        for (cur_room = 0; cur_room<room_constraints.num_of_rooms;cur_room++)
        {
            for (day = 0; day<days_in_week; day++)
            
            { for (hour = 0; hour<hours_in_day; hour++)
                { if(curr_ptr -> bookings[cur_room][day][hour]<10)
                  {c=curr_ptr -> bookings[cur_room][day][hour];
                   t=(c+'0');
                   fputc(t,out1);
                    fputs(" ",out1);
                 //cout<<curr_ptr -> bookings[cur_room][day][hour];
                 //getch();
                   }
                else
                   { c=(curr_ptr -> bookings[cur_room][day][hour])/10;
                     t=(c+'0');
                     fputc(t,out1);
                     c=(curr_ptr -> bookings[cur_room][day][hour])%10;
                     t=(c+'0');
                     fputc(t,out1);
                     fputs(" ",out1);
                   }
                     
              
              fputn(curr_ptr -> bookings[cur_room][day][hour],out);
                 }
                 fputs("\n",out1);
            }
        fputs("...................\n",out1);
        
        }
        //curr_ptr = (curr_ptr -> next);
fclose(out);
fclose(out1);
return(0);
}




int output_lab(file_name_type out_lab_name)
{
        FILE *out,*out1;
        struct time_table  *curr_ptr;
        char c;
        int t,cur_room, day, hour;
        if ((out = fopen(out_lab_name, "w")) == NULL||(out1=fopen("labv","w"))==NULL) 
        {
        fprintf(stderr, "Cannot open output file\n");
        return 1;
        }
        
        curr_ptr = solution_colony.first_time_table;
        for (cur_room = 0; cur_room<lab_constraints.num_of_labs;cur_room++)
        {
            for (day = 0; day<days_in_week; day++)
            {
                for (hour = 0; hour<hours_in_day; hour++)
              {  if(curr_ptr -> lbookings[cur_room][day][hour]<10)
                  {c=curr_ptr -> lbookings[cur_room][day][hour];
                    t=(c+'0');
                     fputc(t,out1);
                     fputs(" ",out1);
                      //cout<<curr_ptr -> lbookings[cur_room][day][hour];
                      //getch();
                    }
                else
                  {  c=(curr_ptr -> lbookings[cur_room][day][hour])/10;
                     t=(c+'0');
                     fputc(t,out1);
                     c=(curr_ptr -> lbookings[cur_room][day][hour])%10;
                    t=(c+'0');
                     fputc(t,out1);
                     fputs(" ",out1);
                     //cout<<curr_ptr -> lbookings[cur_room][day][hour];
                      //getch();
                   }
                     
              
              fputn(curr_ptr -> lbookings[cur_room][day][hour],out);
             }
             fputs("\n",out1);
             }
        fputs("...................\n",out1);
        
            
        }
        //curr_ptr = (curr_ptr -> next);
fclose(out);
fclose(out1);
return(0);
}


int output_tut(file_name_type out_lab_name)
{
        FILE *out,*out1;
        struct time_table  *curr_ptr;
        char c;
        int t,cur_room, day, hour;
        if ((out = fopen(out_lab_name, "w")) == NULL||(out1=fopen("tutv","w"))==NULL) 
        {
        fprintf(stderr, "Cannot open output file\n");
        return 1;
        }
        
        curr_ptr = solution_colony.first_time_table;
        for (cur_room = 0; cur_room<room_constraints.num_of_rooms;cur_room++)
        {
            for (day = 0; day<days_in_week; day++)
            {
                for (hour = 0; hour<hours_in_day; hour++)
              {  if(curr_ptr -> tbookings[cur_room][day][hour]<10)
                  {c=curr_ptr -> tbookings[cur_room][day][hour];
                    t=(c+'0');
                     fputc(t,out1);
                     fputs(" ",out1);
                      //cout<<curr_ptr -> tbookings[cur_room][day][hour];
                      //getch();
                    }
                else
                  {  c=(curr_ptr -> tbookings[cur_room][day][hour])/10;
                     t=(c+'0');
                     fputc(t,out1);
                     c=(curr_ptr -> tbookings[cur_room][day][hour])%10;
                    t=(c+'0');
                     fputc(t,out1);
                     fputs(" ",out1);
                     //cout<<curr_ptr -> lbookings[cur_room][day][hour];
                      //getch();
                   }
                     
              
              fputn(curr_ptr -> tbookings[cur_room][day][hour],out);
             }
             fputs("\n",out1);
             }
        fputs("...................\n",out1);
        
            
        }
        //curr_ptr = (curr_ptr -> next);
fclose(out);
fclose(out1);
return(0);
}
////////////////////

//////

/////
/*int output_debugg(struct time_table  *curr_ptr)
{
        FILE *out1;
        
        char c;
        int t,cur_room, day, hour;
        if ((out1=fopen("tutv","w"))==NULL) 
        {
        fprintf(stderr, "Cannot open output file\n");
        return 1;
        }
        
        
        for (cur_room = 0; cur_room<room_constraints.num_of_rooms;cur_room++)
        {
            for (day = 0; day<days_in_week; day++)
            {
                for (hour = 0; hour<hours_in_day; hour++)
              {  if(curr_ptr -> tbookings[cur_room][day][hour]<10)
                  {c=curr_ptr -> tbookings[cur_room][day][hour];
                    t=(c+'0');
                     fputc(t,out1);
                     fputs(" ",out1);
                      //cout<<curr_ptr -> tbookings[cur_room][day][hour];
                      //getch();
                    }
                else
                  {  c=(curr_ptr -> tbookings[cur_room][day][hour])/10;
                     t=(c+'0');
                     fputc(t,out1);
                     c=(curr_ptr -> tbookings[cur_room][day][hour])%10;
                    t=(c+'0');
                     fputc(t,out1);
                     fputs(" ",out1);
                     //cout<<curr_ptr -> lbookings[cur_room][day][hour];
                      //getch();
                   }
                     
              
              
             }
             fputs("\n",out1);
             }
        fputs("...................\n",out1);
        
            
        }
        
 FILE *out111;
        
        
        if ((out111=fopen("happyv","w"))==NULL) 
        {
        fprintf(stderr, "Cannot open output file\n");
        return 1;
        }
        
        for (cur_room = 0; cur_room<room_constraints.num_of_rooms;cur_room++)
        {
            for (day = 0; day<days_in_week; day++)
            
            { for (hour = 0; hour<hours_in_day; hour++)
                { if(curr_ptr -> bookings[cur_room][day][hour]<10)
                  {c=curr_ptr -> bookings[cur_room][day][hour];
                   t=(c+'0');
                   fputc(t,out111);
                    fputs(" ",out111);
                 //cout<<curr_ptr -> bookings[cur_room][day][hour];
                 //getch();
                   }
                else
                   { c=(curr_ptr -> bookings[cur_room][day][hour])/10;
                     t=(c+'0');
                     fputc(t,out111);
                     c=(curr_ptr -> bookings[cur_room][day][hour])%10;
                     t=(c+'0');
                     fputc(t,out111);
                     fputs(" ",out111);
                   }
                     
              
              
                 }
                 fputs("\n",out111);
            }
        fputs("...................\n",out111);
        
        }       
        FILE *out12;
        
       
        if ((out12=fopen("labv","w"))==NULL) 
        {
        fprintf(stderr, "Cannot open output file\n");
        return 1;
        }
        
        
        for (cur_room = 0; cur_room<lab_constraints.num_of_labs;cur_room++)
        {
            for (day = 0; day<days_in_week; day++)
            {
                for (hour = 0; hour<hours_in_day; hour++)
              {  if(curr_ptr -> lbookings[cur_room][day][hour]<10)
                  {c=curr_ptr -> lbookings[cur_room][day][hour];
                    t=(c+'0');
                     fputc(t,out12);
                     fputs(" ",out12);
                      //cout<<curr_ptr -> lbookings[cur_room][day][hour];
                      //getch();
                    }
                else
                  {  c=(curr_ptr -> lbookings[cur_room][day][hour])/10;
                     t=(c+'0');
                     fputc(t,out12);
                     c=(curr_ptr -> lbookings[cur_room][day][hour])%10;
                    t=(c+'0');
                     fputc(t,out12);
                     fputs(" ",out12);
                     //cout<<curr_ptr -> lbookings[cur_room][day][hour];
                      //getch();
                   }
                     
              
              
             }
             fputs("\n",out12);
             }
        fputs("...................\n",out12);
        
            
        }
        //curr_ptr = (curr_ptr -> next);

fclose(out12);

fclose(out111);

fclose(out1);
return(0);
}*/
