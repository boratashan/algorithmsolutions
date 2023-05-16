use std::collections::HashMap;
use shuffle::shuffler::Shuffler;
use shuffle::irs::Irs;
use rand::rngs::mock::StepRng;

fn main() {
    for i in (1..20) {
      let mut  v  =  generate();
      print( &mut v);
      sortEmAll(&mut v);
      print!(" -> ");
      print( &mut v);
      if testSortedVec(&mut v) {
        print!(" [Passed]");
      }
      else {
        print!(" [Failed]");
      }

      println!();
     

    }
}

fn generate() -> Vec<char>  {
  let mut v : Vec<char> = Vec::new();
  let mut c : char  = 'A';
  for  number in (1..24) { 
     v.push(c);
     v.push(c);
     c = (c as u8 + 1) as char; 
  }
  let mut rng = StepRng::new(2, 13);
  let mut irs = Irs::default();
  irs.shuffle(&mut v, &mut rng);
  return v;
}

fn print(input: &mut Vec<char>)  {
  for c in input {
    print!("{}", c);
  }
}


fn sortEmAll(input: &mut Vec<char>)  {
  let mut table: HashMap<char, usize>= HashMap::new();
  let mut idx: usize = 0;
  while idx < input.len() {
    let s = &input[idx];
    let hv: Option<&usize> = table.get(s);
    match hv {
      Some(hv) => {
        let sdx = if ((hv+1) % 2 == 0) {hv-1} else {hv+1};
        input.swap(idx, sdx);
        let s = &input[idx];
        table.insert(s.clone(), idx);
      },
      None => { 
        table.insert(s.clone(), idx);
      },
    }
    idx += 1;
  }
}

fn testSortedVec(input: &mut Vec<char>) -> bool {
  let mut res = 2;
  let mut p = input.get(0).copied().unwrap();
  for c in input {
     if c==&p {res -= 1} else { res += 1 }; 
     p = c.clone();
  }
  return res == 0;

}
