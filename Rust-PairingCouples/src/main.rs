use std::arch::aarch64::int32x2x4_t;
use std::vec;
use std::{collections::HashMap, str::Chars};
use shuffle::shuffler::Shuffler;
use shuffle::irs::Irs;
use rand::rngs::mock::StepRng;

fn main() {

    let mut scores = HashMap::new();

    scores.insert(String::from("Blue"), 10);
    scores.insert(String::from("Yellow"), 50);
    println!("Hello, world!");

    let mut v  =  generate();

    for c in v {
      print!("{}", c);
    }
    let mut vv : Vec<char> = v.clone();
    dummyone( vv);

}


fn generate() -> Vec<char>  {
  let mut v : Vec<char> = Vec::new();
  let mut c : char  = 'A';
  for  number in (1..10) { 
     v.push(c);
     v.push(c);
     c = (c as u8 + 1) as char; 
  }
  let mut rng = StepRng::new(2, 13);
  let mut irs = Irs::default();
  irs.shuffle(&mut v, &mut rng);
  return v;
}

fn dummyone(input: &mut Vec<char>)  {
  let mut table : HashMap<char, i32> = HashMap::new();

  let mut i = 0;
  let mut c: char;
  while i < input.len() {
   // c = input.get(i).as_mut();
    //print!("{}", c);
    i += 1;
  }

}

